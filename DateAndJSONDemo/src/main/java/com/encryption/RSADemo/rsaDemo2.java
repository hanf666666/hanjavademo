package com.encryption.RSADemo;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

import java.io.UnsupportedEncodingException;

/**
 * to do
 * 成功
 * @author Hj
 * @date 2022/10/18
 */
public class rsaDemo2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJxzlYn6E28Zi4ai3YOrFps8YTcFA4N64fQ2e0CLgNOtqcfwhU+Ljyg9K3qBJihPqryFxXpYXTTEnkU4TexPeNFjDNRVxPPk1tOmMR1JgCFoBXVk2e4e1QEGkYn/1aOgCDDnQCyzJ2GbeI1IIIv5e+Jo2Y6oXPWkiajIlCfPD0dhAgMBAAECgYAM0cO9DIqvHc6693ljIo+1pJrqoTSKf3UoR5aN0WB6983jnieuPuc6CtkXLqHrx6tbyzJFNhxdCIdXcKeh51kk3YLyP9wMWyIGPyp0YbsDHsPsYjdxT5ItTORMkYBLmg4ZduKhDmEv1QuUTSRcFRIeyi36rV233vHZy7Iy2mQv6QJBAPhHp09pICquy7yV2utyedKjTxrJYpCqa5zJdIt0ZOF7I8Oc6SRAjpRS2X5HtZnVuV1JL/hz+d+0fLBqTmx1B7cCQQChUPZaoQlx9mLQf1hJrbKPCnkjE7bLHausQXusZrj1lDmePw9C5oc3zRAklV7WuYWcQp+NeMyjGBGcN0Q8/LmnAkEA83cAYGTMQE7MRxAEb2IAiEfQqInW99nGUSdT+/SVgG8KcSYLkZsktdpQoP6c3E+yyAGe4tqHq5EHvM9iPAS/HQJAT7d0pkCiLED3f9UOSgqeDHW+ewkI8cLNzSfm98Ejcag3+O1sm0DUXUzmx01ROocfcaKyufSSG56PRUVCYWj6TQJAAKHijiAM2xU31ccKloSDlmbfzBzF8YWX0KryTMypLc2/AWSFve2Mejz4Ioc99IljRUvUHGem/gC+5hccW2cgxg==";
        String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCcc5WJ+hNvGYuGot2DqxabPGE3BQODeuH0NntAi4DTranH8IVPi48oPSt6gSYoT6q8hcV6WF00xJ5FOE3sT3jRYwzUVcTz5NbTpjEdSYAhaAV1ZNnuHtUBBpGJ/9WjoAgw50Assydhm3iNSCCL+XviaNmOqFz1pImoyJQnzw9HYQIDAQAB";

        RSA rsa = new RSA(PRIVATE_KEY, PUBLIC_KEY);
        System.out.println("sadfa你好");
        //私钥加密，公钥解密
        byte[] encrypt2 = rsa.encrypt(StrUtil.bytes("sadfa你好", CharsetUtil.CHARSET_GBK), KeyType.PrivateKey);
        String encode = Base64.encode(encrypt2);
        System.out.println(encode);

        byte[] decrypt2 = rsa.decrypt(Base64.decode(encode), KeyType.PublicKey);
        System.out.println(StrUtil.str(decrypt2, CharsetUtil.CHARSET_GBK));
        //Assert.assertEquals("我是一段测试aaaa", StrUtil.str(decrypt2, CharsetUtil.CHARSET_UTF_8));




//        String str = StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8);
//        System.out.println(str);






    }
}
