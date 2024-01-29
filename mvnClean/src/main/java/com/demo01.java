package com;

/**
 * to do
 *
 * @author Hj
 * @date 2024/1/26
 */
public class demo01 {
    public static void main(String[] args) {
        //datecenter
//        String alitest = "boss-manage-bkt-test";
//        String aliProd = "boss-manage-bkt";
//        String txtest = "boss-manage-test-1320652165";
//        String txProd = "boss-manage-bkt-1320652165";

        //datecenter
        String alitest = "close-park-bkt-test";
        String aliProd = "close-park-bkt";
        String txtest = "close-park-test-1320652165";
        String txProd = "close-park-bkt-1320652165";



        String centosaliTest = "#∞¢¿Ô‘∆centos===test==================================================================================================================\n" +
                "#∞¢¿Ô‘∆OSS≈‰÷√\n" +
                "aliyun.oss.accessKeyId = LTAIIycUv6qReilC\n" +
                "aliyun.oss.accessKeySecret = o36X3KNsdo6q91IbHD5X04dcFm3Nab\n" +
                "aliyun.oss.bucketName = " + alitest + "\n" +
                "aliyun.oss.endpoint = oss-cn-beijing.aliyuncs.com\n" +
                "aliyun.oss.enable = true\n" +
                "\n" +
                "#============== cos ===================\n" +
                "tencent.cos.secretId = AKIDymdSBC1d193lHbm7HCsJVS9mLqDTXP3f\n" +
                "tencent.cos.secretKey = ub4KL9i14rV6dyW7ez5xax583kDTUPF0\n" +
                "tencent.cos.bucketName = " + txtest + "\n" +
                "tencent.cos.endpoint = https://" + txtest + ".cos.ap-nanjing.myqcloud.com\n" +
                "tencent.cos.region = ap-nanjing\n" +
                "tencent.cos.enabled = true\n" +
                "\n" +
                "file.store.default.upload.type = AliOss\n" +
                "\n" +
                "#============== cos ===================";

        String centosTXTest = "#Ã⁄—∂‘∆centos============test=========================================================================================================\n" +
                "#∞¢¿Ô‘∆OSS≈‰÷√\n" +
                "aliyun.oss.accessKeyId = LTAIIycUv6qReilC\n" +
                "aliyun.oss.accessKeySecret = o36X3KNsdo6q91IbHD5X04dcFm3Nab\n" +
                "aliyun.oss.bucketName = " + alitest + "\n" +
                "aliyun.oss.endpoint = oss-cn-beijing.aliyuncs.com\n" +
                "aliyun.oss.enable = true\n" +
                "\n" +
                "#============== cos ===================\n" +
                "tencent.cos.secretId = AKIDymdSBC1d193lHbm7HCsJVS9mLqDTXP3f\n" +
                "tencent.cos.secretKey = ub4KL9i14rV6dyW7ez5xax583kDTUPF0\n" +
                "tencent.cos.bucketName = " + txtest + "\n" +
                "tencent.cos.endpoint = https://" + txtest + ".cos.ap-nanjing.myqcloud.com\n" +
                "tencent.cos.region = ap-nanjing\n" +
                "tencent.cos.enabled = true\n" +
                "\n" +
                "file.store.default.upload.type = TencentCOS\n" +
                "\n" +
                "#============== cos ===================";


        String centosaliProd = "#∞¢¿Ô‘∆centos===========Prod==========================================================================================================\n" +
                "#∞¢¿Ô‘∆OSS≈‰÷√\n" +
                "aliyun.oss.accessKeyId = LTAIIycUv6qReilC\n" +
                "aliyun.oss.accessKeySecret = o36X3KNsdo6q91IbHD5X04dcFm3Nab\n" +
                "aliyun.oss.bucketName = " + aliProd + "\n" +
                "aliyun.oss.endpoint = oss-cn-beijing.aliyuncs.com\n" +
                "aliyun.oss.enable = true\n" +
                "\n" +
                "#============== cos ===================\n" +
                "tencent.cos.secretId = AKIDymdSBC1d193lHbm7HCsJVS9mLqDTXP3f\n" +
                "tencent.cos.secretKey = ub4KL9i14rV6dyW7ez5xax583kDTUPF0\n" +
                "tencent.cos.bucketName = " + txProd + "\n" +
                "tencent.cos.endpoint = https://" + txProd + ".cos.ap-nanjing.myqcloud.com\n" +
                "tencent.cos.region = ap-nanjing\n" +
                "tencent.cos.enabled = true\n" +
                "\n" +
                "file.store.default.upload.type = AliOss\n" +
                "\n" +
                "#============== cos ===================";


        String centosTXProd = "#Ã⁄—∂‘∆centos======Prod===============================================================================================================\n" +
                "#∞¢¿Ô‘∆OSS≈‰÷√\n" +
                "aliyun.oss.accessKeyId = LTAIIycUv6qReilC\n" +
                "aliyun.oss.accessKeySecret = o36X3KNsdo6q91IbHD5X04dcFm3Nab\n" +
                "aliyun.oss.bucketName = " + aliProd + "\n" +
                "aliyun.oss.endpoint = oss-cn-beijing.aliyuncs.com\n" +
                "aliyun.oss.enable = true\n" +
                "\n" +
                "#============== cos ===================\n" +
                "tencent.cos.secretId = AKIDymdSBC1d193lHbm7HCsJVS9mLqDTXP3f\n" +
                "tencent.cos.secretKey = ub4KL9i14rV6dyW7ez5xax583kDTUPF0\n" +
                "tencent.cos.bucketName = " + txProd + "\n" +
                "tencent.cos.endpoint = https://" + txProd + ".cos.ap-nanjing.myqcloud.com\n" +
                "tencent.cos.region = ap-nanjing\n" +
                "tencent.cos.enabled = true\n" +
                "\n" +
                "file.store.default.upload.type = TencentCOS\n" +
                "\n" +
                "#============== cos ===================";
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(centosaliTest);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(centosTXTest);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(centosaliProd);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(centosTXProd);


    }


}
