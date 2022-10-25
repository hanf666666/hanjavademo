package com.encryption.RSADemo;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;

import java.io.UnsupportedEncodingException;

/**
 * to do
 *
 * @author Hj
 * @date 2022/10/18
 */
public class rsaDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIS/868LjagiZsCmyC3o9gIVoH2hfBSFXeTLGdqg7B++fvGQPeecgS/NioX6OND3XTIgBWctroG6s8CHZPuo3TjGVAbEq0mudKrTvbHXynSdmGINtt9SQ0frN+fN61+SJzhFKALxIuKWGlbsY43SdNPuRoR55928vG1UcBTX40WrAgMBAAECgYA3KhU3rpNlRTZx5FzXRzHD1/zjeBG57VoBU60gvzKgVmcmNwyijNTaao2f80VdAQ5HYCsen0sfOdisrxb1xUx4SjEqSDAllhbb1AYL6Ei6gF814OovLClnezSuOZsiHkaLAS9XvxEooi5lr09uMXCvEFCWFh6BrjeLfLmtcGWUgQJBANhy1jnLkeBLV1Eot+QsMuivNf6m0a2DG8Fvu3HZYb3ltVveNLwx9+Im/WN0Ya550WyzIqjO9GRUsk81zbNmFssCQQCdAc2fb+XE6FqlU1ibTvg0/4XiWwu5Av29fgM0JSHuRNiCp9pxF7kO6guEfKqGY/JimLewTfLB4XHZIXEHPtChAkAMp+pOxtBoxP7+B9t4w/zWDiiiEy7/bkMZNGdJaOSGLgBEtuFuf51248C9J/juMsFEEdVc+XzgwPMMHqFAdB+xAkEAgd279uTXaMfIMnd+Evh+1VeFpnUofR+8QcC5ZahRKIRJkcjFJkY5C90LKcr0QbTqCCPJzEqtQTD4umCu3Q9YAQJBALy4s80qixTg5f3bNyy51Ww4hVNtJQ9mz+z1tO1N9y6fKo2rQxoOAo3eVE/l5akXX1QRlpPbdZYEnCo0N6leRgs=";
        String PUBLIC_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIS/868LjagiZsCmyC3o9gIVoH2hfBSFXeTLGdqg7B++fvGQPeecgS/NioX6OND3XTIgBWctroG6s8CHZPuo3TjGVAbEq0mudKrTvbHXynSdmGINtt9SQ0frN+fN61+SJzhFKALxIuKWGlbsY43SdNPuRoR55928vG1UcBTX40WrAgMBAAECgYA3KhU3rpNlRTZx5FzXRzHD1/zjeBG57VoBU60gvzKgVmcmNwyijNTaao2f80VdAQ5HYCsen0sfOdisrxb1xUx4SjEqSDAllhbb1AYL6Ei6gF814OovLClnezSuOZsiHkaLAS9XvxEooi5lr09uMXCvEFCWFh6BrjeLfLmtcGWUgQJBANhy1jnLkeBLV1Eot+QsMuivNf6m0a2DG8Fvu3HZYb3ltVveNLwx9+Im/WN0Ya550WyzIqjO9GRUsk81zbNmFssCQQCdAc2fb+XE6FqlU1ibTvg0/4XiWwu5Av29fgM0JSHuRNiCp9pxF7kO6guEfKqGY/JimLewTfLB4XHZIXEHPtChAkAMp+pOxtBoxP7+B9t4w/zWDiiiEy7/bkMZNGdJaOSGLgBEtuFuf51248C9J/juMsFEEdVc+XzgwPMMHqFAdB+xAkEAgd279uTXaMfIMnd+Evh+1VeFpnUofR+8QcC5ZahRKIRJkcjFJkY5C90LKcr0QbTqCCPJzEqtQTD4umCu3Q9YAQJBALy4s80qixTg5f3bNyy51Ww4hVNtJQ9mz+z1tO1N9y6fKo2rQxoOAo3eVE/l5akXX1QRlpPbdZYEnCo0N6leRgs=";

        RSA rsa = new RSA(PRIVATE_KEY, PUBLIC_KEY);
        String textStr = "发的说法是否理发师大幅拉升了大幅拉升的理发师多了";
        byte[] encrypt = rsa.encrypt(textStr.getBytes(), KeyType.PublicKey);



//        byte[] aByte = HexUtil.decodeHex(a);
        byte[] decrypt = rsa.decrypt(encrypt, KeyType.PrivateKey);
        System.out.println(new String(decrypt,"utf-8"));


        String str = StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8);
        System.out.println(str);






    }
}
