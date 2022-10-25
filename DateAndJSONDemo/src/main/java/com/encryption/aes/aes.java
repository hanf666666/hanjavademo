package com.encryption.aes;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;

/**
 * to do
 *
 * @author Hj
 * @date 2022/10/18
 */
public class aes {
    public static void main(String[] args) {
        String content = "test中文";
        System.out.println(content);
        // 随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        // 构建
        AES aes = SecureUtil.aes(key);
        // 加密
         byte[] encrypt = aes.encrypt(content);
        System.out.println(encrypt);
        // 解密
         byte[] decrypt = aes.decrypt(encrypt);
        System.out.println(decrypt);
        // 加密为16进制表示
        String encryptHex = aes.encryptHex(content);
        System.out.println(encryptHex);
        // 解密为字符串
        String decryptStr = aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
        System.out.println(decryptStr);
    }
}
