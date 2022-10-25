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
        String content = "test����";
        System.out.println(content);
        // ���������Կ
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        // ����
        AES aes = SecureUtil.aes(key);
        // ����
         byte[] encrypt = aes.encrypt(content);
        System.out.println(encrypt);
        // ����
         byte[] decrypt = aes.decrypt(encrypt);
        System.out.println(decrypt);
        // ����Ϊ16���Ʊ�ʾ
        String encryptHex = aes.encryptHex(content);
        System.out.println(encryptHex);
        // ����Ϊ�ַ���
        String decryptStr = aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
        System.out.println(decryptStr);
    }
}
