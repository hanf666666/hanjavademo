package com.encryption;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import cn.hutool.crypto.KeyUtil;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 微信支付回调通知测试
 *
 * @author 小傅哥
 * @version 1.0
 */
public class WechatPayNotifyDemo {

    public static void main(String[] args) throws Exception {

        testV2();
        System.out.println();
        System.out.println("==================================================");
        System.out.println();
        testV3();
    }

    // ================== V2 测试 ==================
    static void testV2() {
        System.out.println("########## 微信 V2 回调测试 ##########");
        String apiKey = "192006250b4c09247ec02edce69f6a2d"; // 32 位商户密钥

        // 场景1：支付结果通知验签
        Map<String, String> params = new LinkedHashMap<>();
        params.put("return_code", "SUCCESS");
        params.put("result_code", "SUCCESS");
        params.put("appid", "wx2421b1c4370ec43b");
        params.put("mch_id", "10000100");
        params.put("out_trade_no", "2023111400001");
        params.put("transaction_id", "4200001234202311140000000000");
        params.put("total_fee", "1");
        params.put("nonce_str", "ibuaiVcKdpRxkhJA");

        // 1. 模拟微信侧：计算签名
        params.put("sign", signV2(params, apiKey, "MD5"));

        // 2. 模拟微信侧：生成回调 XML
        String xml = XmlUtil.mapToXmlStr(params, "xml");
        System.out.println("[V2] 模拟回调 XML:");
        System.out.println(xml);

        // 3. 商户侧：验签
        boolean ok = verifyV2(xml, apiKey, "MD5");
        System.out.println("[V2] 验签结果: " + (ok ? "? 通过" : "? 失败"));

        // 4. 篡改报文，验签应失败
        String tamperedXml = xml.replace("total_fee>1<", "total_fee>100<");
        boolean bad = verifyV2(tamperedXml, apiKey, "MD5");
        System.out.println("[V2] 篡改报文验签结果: " + (bad ? "? 竟然通过" : "? 正确拦截"));

        // 场景2：模拟微信侧 退款通知 req_info
        System.out.println();
        String refundPlain = "<root><out_refund_no>REF20231114001</out_refund_no>"
                + "<refund_fee>1</refund_fee></root>";
        String reqInfoCipher = encryptV2ReqInfo(refundPlain, apiKey);
        System.out.println("[V2] req_info 加密结果: " + reqInfoCipher);
        //我方商户侧  但是真没加密
        String reqInfoPlain = decryptV2ReqInfo(reqInfoCipher, apiKey);
        System.out.println("[V2] req_info 解密结果: " + reqInfoPlain);
    }

    // ================== V3 测试 ==================
    static void testV3() throws Exception {
        System.out.println("########## 微信 V3 回调测试 ##########");
        String apiV3Key = "abcdefghijklmnopqrstuvwxyz123456"; // 32 位 APIv3 密钥
        String associatedData = "transaction";
        String resourceNonce = "abcdefgh1234"; // 12 字节
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        String httpNonce = "randomNonce123";

        // 1. 生成 RSA 密钥对（模拟微信平台证书密钥对）
        KeyPair kp = KeyUtil.generateKeyPair("RSA", 2048);
        PrivateKey priv = kp.getPrivate();
        PublicKey pub = kp.getPublic();

        // 2. 模拟业务明文
        JSONObject biz = JSONUtil.createObj()
                .set("original_type", "transaction")
                .set("resource", JSONUtil.createObj()
                        .set("out_trade_no", "2023111400001")
                        .set("transaction_id", "4200001234202311140000000000")
                        .set("trade_state", "SUCCESS")
                        .set("payer_total", 1));
        String plain = biz.toString();

        // 3. 模拟微信：AES-256-GCM 加密
        String ciphertext = encryptV3Data(plain, apiV3Key, associatedData, resourceNonce);

        // 4. 模拟微信：组装回调 body
        JSONObject resource = JSONUtil.createObj()
                .set("original_type", "transaction")
                .set("algorithm", "AEAD_AES_256_GCM")
                .set("ciphertext", ciphertext)
                .set("associated_data", associatedData)
                .set("nonce", resourceNonce);
        String body = JSONUtil.createObj()
                .set("id", "EV-2023111400001")
                .set("create_time", "2023-11-14T10:00:00+08:00")
                .set("event_type", "TRANSACTION.SUCCESS")
                .set("resource_type", "encrypt-resource")
                .set("resource", resource)
                .set("summary", "支付成功")
                .toString();
        System.out.println("[V3] 模拟回调 body:");
        System.out.println(body);

        // 5. 模拟微信：SHA256withRSA 签名
        String signSource = timestamp + "\n" + httpNonce + "\n" + body + "\n";
        Sign signer = new Sign(SignAlgorithm.SHA256withRSA, priv, null);
        String signature = Base64.encode(signer.sign(signSource.getBytes(StandardCharsets.UTF_8)));
        System.out.println("[V3] 模拟 Wechatpay-Signature: " + signature);

        // 6. 商户：验签
        boolean ok = verifyV3(timestamp, httpNonce, body, signature, pub);
        System.out.println("[V3] 验签结果: " + (ok ? "? 通过" : "? 失败"));

        // 7. 篡改 body，验签应失败
        boolean bad = verifyV3(timestamp, httpNonce, body + "x", signature, pub);
        System.out.println("[V3] 篡改 body 验签结果: " + (bad ? "? 竟然通过" : "? 正确拦截"));

        // 8. 商户：解密 resource
        JSONObject decrypted = decryptV3Resource(resource, apiV3Key);
        System.out.println("[V3] resource 解密结果: " + decrypted);
    }

    // ================== V2 工具 ==================
    static String buildV2SignSource(Map<String, ?> params, String apiKey) {
        TreeMap<String, String> sorted = new TreeMap<>();
        params.forEach((k, v) -> {
            String s = v == null ? "" : v.toString();
            if (StrUtil.isNotBlank(s) && !"sign".equals(k)) {
                sorted.put(k, s.trim());
            }
        });
        StringBuilder sb = new StringBuilder();
        sorted.forEach((k, v) -> sb.append(k).append("=").append(v).append("&"));
        sb.append("key=").append(apiKey);
        return sb.toString();
    }

    static String signV2(Map<String, ?> params, String apiKey, String signType) {
        String source = buildV2SignSource(params, apiKey);
        if ("HMAC-SHA256".equalsIgnoreCase(signType)) {
            HMac hmac = new HMac(HmacAlgorithm.HmacSHA256,
                    apiKey.getBytes(StandardCharsets.UTF_8));
            return hmac.digestHex(source).toUpperCase();
        }
        return DigestUtil.md5Hex(source).toUpperCase();
    }

    static boolean verifyV2(String xml, String apiKey, String signType) {
        Map<String, Object> map = XmlUtil.xmlToMap(xml);
        Object signObj = map.get("sign");
        if (signObj == null) return false;
        String received = signObj.toString().toUpperCase();
        return signV2(map, apiKey, signType).equals(received);
    }

    /** V2 退款 req_info 加密：key = MD5(apiKey) 的 32 位小写字符串，AES-256-ECB + PKCS5 */
    static String encryptV2ReqInfo(String plain, String apiKey) {
        String keyStr = DigestUtil.md5Hex(apiKey).toLowerCase(); // 32 字符 → 32 字节
        AES aes = new AES(Mode.ECB, Padding.PKCS5Padding,
                keyStr.getBytes(StandardCharsets.UTF_8));
        return aes.encryptBase64(plain, StandardCharsets.UTF_8);
    }

    static String decryptV2ReqInfo(String cipherBase64, String apiKey) {
        String keyStr = DigestUtil.md5Hex(apiKey).toLowerCase();
        AES aes = new AES(Mode.ECB, Padding.PKCS5Padding,
                keyStr.getBytes(StandardCharsets.UTF_8));
        return aes.decryptStr(Base64.decode(cipherBase64), StandardCharsets.UTF_8);
    }

    // ================== V3 工具 ==================
    /** V3 resource 加密：AES-256-GCM + 128 位 tag + AAD。Hutool AES 不支持 GCM，走原生 JCE */
    static String encryptV3Data(String plain, String apiV3Key,
                                String associatedData, String nonce) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        SecretKeySpec key = new SecretKeySpec(
                apiV3Key.getBytes(StandardCharsets.UTF_8), "AES");
        GCMParameterSpec spec = new GCMParameterSpec(
                128, nonce.getBytes(StandardCharsets.UTF_8));
        cipher.init(Cipher.ENCRYPT_MODE, key, spec);
        if (StrUtil.isNotEmpty(associatedData)) {
            cipher.updateAAD(associatedData.getBytes(StandardCharsets.UTF_8));
        }
        return Base64.encode(cipher.doFinal(plain.getBytes(StandardCharsets.UTF_8)));
    }

    static JSONObject decryptV3Resource(JSONObject resource, String apiV3Key) throws Exception {
        String ciphertext = resource.getStr("ciphertext");
        String nonce = resource.getStr("nonce");
        String associatedData = resource.getStr("associated_data", "");

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        SecretKeySpec key = new SecretKeySpec(
                apiV3Key.getBytes(StandardCharsets.UTF_8), "AES");
        GCMParameterSpec spec = new GCMParameterSpec(
                128, nonce.getBytes(StandardCharsets.UTF_8));
        cipher.init(Cipher.DECRYPT_MODE, key, spec);
        if (StrUtil.isNotEmpty(associatedData)) {
            cipher.updateAAD(associatedData.getBytes(StandardCharsets.UTF_8));
        }
        byte[] plainBytes = cipher.doFinal(Base64.decode(ciphertext));
        return JSONUtil.parseObj(new String(plainBytes, StandardCharsets.UTF_8));
    }

    static boolean verifyV3(String timestamp, String nonce, String body,
                            String signature, PublicKey platformPub) {
        String signSource = timestamp + "\n" + nonce + "\n" + body + "\n";
        Sign verifier = new Sign(SignAlgorithm.SHA256withRSA, null, platformPub);
        return verifier.verify(
                signSource.getBytes(StandardCharsets.UTF_8), Base64.decode(signature));
    }
}
