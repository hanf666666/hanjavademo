package com.encryption.RSADemo;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * to do
 *
 * @author Hj
 * @date 2022/10/18
 */
//privatekeyStr:  MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIS/868LjagiZsCmyC3o9gIVoH2hfBSFXeTLGdqg7B++fvGQPeecgS/NioX6OND3XTIgBWctroG6s8CHZPuo3TjGVAbEq0mudKrTvbHXynSdmGINtt9SQ0frN+fN61+SJzhFKALxIuKWGlbsY43SdNPuRoR55928vG1UcBTX40WrAgMBAAECgYA3KhU3rpNlRTZx5FzXRzHD1/zjeBG57VoBU60gvzKgVmcmNwyijNTaao2f80VdAQ5HYCsen0sfOdisrxb1xUx4SjEqSDAllhbb1AYL6Ei6gF814OovLClnezSuOZsiHkaLAS9XvxEooi5lr09uMXCvEFCWFh6BrjeLfLmtcGWUgQJBANhy1jnLkeBLV1Eot+QsMuivNf6m0a2DG8Fvu3HZYb3ltVveNLwx9+Im/WN0Ya550WyzIqjO9GRUsk81zbNmFssCQQCdAc2fb+XE6FqlU1ibTvg0/4XiWwu5Av29fgM0JSHuRNiCp9pxF7kO6guEfKqGY/JimLewTfLB4XHZIXEHPtChAkAMp+pOxtBoxP7+B9t4w/zWDiiiEy7/bkMZNGdJaOSGLgBEtuFuf51248C9J/juMsFEEdVc+XzgwPMMHqFAdB+xAkEAgd279uTXaMfIMnd+Evh+1VeFpnUofR+8QcC5ZahRKIRJkcjFJkY5C90LKcr0QbTqCCPJzEqtQTD4umCu3Q9YAQJBALy4s80qixTg5f3bNyy51Ww4hVNtJQ9mz+z1tO1N9y6fKo2rQxoOAo3eVE/l5akXX1QRlpPbdZYEnCo0N6leRgs=
//publicKeyStr:  MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCEv/OvC42oImbApsgt6PYCFaB9oXwUhV3kyxnaoOwfvn7xkD3nnIEvzYqF+jjQ910yIAVnLa6BurPAh2T7qN04xlQGxKtJrnSq072x18p0nZhiDbbfUkNH6zfnzetfkic4RSgC8SLilhpW7GON0nTT7kaEeefdvLxtVHAU1+NFqwIDAQAB
public class generateKeyPairDemo {
    public static void main(String[] args) {
        KeyPair pair = SecureUtil.generateKeyPair("RSA");
        PrivateKey privatekey = pair.getPrivate();
        String privatekeyStr = Base64.encode(privatekey.getEncoded());
        System.out.println("privatekeyStr:  "+privatekeyStr);

        PublicKey publicKey = pair.getPublic();
        String publicKeyStr = Base64.encode(publicKey.getEncoded());
        System.out.println("publicKeyStr:  "+publicKeyStr);

    }
}
