package com.xml;


/**
 * to do
 * �˵��ָ�
 *
 * @author Hj
 * @date 2023/7/10
 */
public  class splitdemo2 {
    public static void main(String[] args) {
        String sql = "20230713|!319416494461|!EEC0000031726418|!1|!500500301013002217327|!�����̹������������Ƽ����޹�˾|!6228480478372203578|!¡��|!567.62|!�跽|!79_1689234241701>>null|!79_1689234241701>>null";

        String[] split = sql.split("\\|!");
        System.out.println(split.length);
        System.out.println(split[0]);
        System.out.println(split[1]);
        System.out.println(split[2]);
        System.out.println(split[11].split(">>")[0]);




    }
}

