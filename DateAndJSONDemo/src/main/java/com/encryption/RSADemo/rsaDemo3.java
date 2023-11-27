package com.encryption.RSADemo;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
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
public class rsaDemo3 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJxzlYn6E28Zi4ai3YOrFps8YTcFA4N64fQ2e0CLgNOtqcfwhU+Ljyg9K3qBJihPqryFxXpYXTTEnkU4TexPeNFjDNRVxPPk1tOmMR1JgCFoBXVk2e4e1QEGkYn/1aOgCDDnQCyzJ2GbeI1IIIv5e+Jo2Y6oXPWkiajIlCfPD0dhAgMBAAECgYAM0cO9DIqvHc6693ljIo+1pJrqoTSKf3UoR5aN0WB6983jnieuPuc6CtkXLqHrx6tbyzJFNhxdCIdXcKeh51kk3YLyP9wMWyIGPyp0YbsDHsPsYjdxT5ItTORMkYBLmg4ZduKhDmEv1QuUTSRcFRIeyi36rV233vHZy7Iy2mQv6QJBAPhHp09pICquy7yV2utyedKjTxrJYpCqa5zJdIt0ZOF7I8Oc6SRAjpRS2X5HtZnVuV1JL/hz+d+0fLBqTmx1B7cCQQChUPZaoQlx9mLQf1hJrbKPCnkjE7bLHausQXusZrj1lDmePw9C5oc3zRAklV7WuYWcQp+NeMyjGBGcN0Q8/LmnAkEA83cAYGTMQE7MRxAEb2IAiEfQqInW99nGUSdT+/SVgG8KcSYLkZsktdpQoP6c3E+yyAGe4tqHq5EHvM9iPAS/HQJAT7d0pkCiLED3f9UOSgqeDHW+ewkI8cLNzSfm98Ejcag3+O1sm0DUXUzmx01ROocfcaKyufSSG56PRUVCYWj6TQJAAKHijiAM2xU31ccKloSDlmbfzBzF8YWX0KryTMypLc2/AWSFve2Mejz4Ioc99IljRUvUHGem/gC+5hccW2cgxg==";
        String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCfxHSsEI87WHUhcdl9tfLBtHYY9RMoNizi52lzHGkCjKWyds8H7I4+9WOSlJatyhjoCPRryRf04sm8zZIztn9iMaAXvHUeDv0Quy1gugisOJuM0f80k0C5NY8eV4hbWe2owkX9C/7d1XBeqigbQW0EDj4YbTqvxvgUHocSVpxp4wIDAQAB";

        RSA rsa = new RSA(null, PUBLIC_KEY);

        String encode="d4k78aRQv8I9wqO9E6McpYx2Iy2oqNCN887UUk+AkcuSsV4xeDJbB039sRahjyylRpxNJJ1CxTI6yGAyBoKjTc5bT0tkhbN1uOKYrP2egDQro9nSnzTxy0iCvpL+LC06YfTNJwBrMJGHEV4VGciq+dzdaYyhItuHgSDStIxyKXQ=";

        byte[] decrypt2 = rsa.decrypt(Base64.decode(encode), KeyType.PublicKey);
        System.out.println(StrUtil.str(decrypt2, CharsetUtil.CHARSET_GBK));
        //Assert.assertEquals("Œ“ «“ª∂Œ≤‚ ‘aaaa", StrUtil.str(decrypt2, CharsetUtil.CHARSET_UTF_8));




//        String str = StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8);
//        System.out.println(str);






    }
}
