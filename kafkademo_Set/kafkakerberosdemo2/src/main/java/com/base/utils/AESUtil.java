package com.base.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.KeySpec;
import java.util.Base64;

/**
 * to do
 *
 * @author : Hj
 * @date : 2020/8/31
 */
public class AESUtil {

    private static String salt = "ssshhhhhhhhhhh!!!!";


    public static String encrypt(String strToEncrypt, String secretKey)
    {
        try
        {
//            SecureRandom random = new SecureRandom();
//            byte[] iv = random.generateSeed(16);
//            IvParameterSpec ips = new IvParameterSpec(iv);
            byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey2 = new SecretKeySpec(tmp.getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey2, ivspec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }


    public static String decrypt(String strToDecrypt, String secretKey) {
        try
        {

           byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            /*SecureRandom random = new SecureRandom();
            byte[] iv = random.generateSeed(16);
            for (Byte i: iv) {
                System.out.println(i);

            }
            IvParameterSpec ivspec = new IvParameterSpec(iv);*/

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey2 = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey2, ivspec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
        catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }


   public static void main(String[] args)
    {
//        String originalString = "Dw@Pwd200511";
        String originalString = "Qyw.ydd2020!";
        String secretKey = "34EA158849B9BAD07DE0";
        String encryptedString = encrypt(originalString, secretKey) ;
        String decryptedString = decrypt("Kg+LxRxFurEqwiYUFtWbPw==", secretKey) ;

        System.out.println("‘≠ º√‹¬Î+="+originalString);
        System.out.println("±‡“Î+="+encryptedString);
        System.out.println("Ω‚√‹+="+decryptedString);
    }
}
