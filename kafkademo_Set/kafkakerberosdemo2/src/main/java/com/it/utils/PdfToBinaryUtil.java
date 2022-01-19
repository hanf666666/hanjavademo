package com.it.utils;

/**
 * to do
 *
 * @author Hj
 * @date 2021/1/13
 */

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

public class PdfToBinaryUtil {
    static BASE64Encoder encoder = new BASE64Encoder();
    static BASE64Decoder decoder = new BASE64Decoder();

    public static void main(String[] args) {

        String base64String = getPDFBinary("D:\\export\\servers\\tomcat\\pdfdata\\电力分析报告[16470000401]20210201_000000_1.pdf");

        System.out.println("base64String=="+base64String.length());
        //FileTool.writeStringToFile(base64String, "1.txt");
        //FileTool可参考https://blog.csdn.net/Kangyucheng/article/details/86981414
        base64StringToPDF(base64String, "D:\\export\\servers\\tomcat\\pdfdata\\电力分析报告[16470000401]20210201_000001_1.pdf");

    }


    public static String getPDFBinary(String filePath) {

        try {
            byte[] bytes = getBytes(filePath);
            System.out.println("bytes.length==="+bytes.length);
            return encoder.encodeBuffer(bytes).trim();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    public static byte[] getBytes(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferInputStream = new BufferedInputStream(fileInputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bout = new BufferedOutputStream(byteArrayOutputStream);
        byte[] buffer = new byte[1024];
        int len = bufferInputStream.read(buffer);
        while (len != -1) {
            bout.write(buffer, 0, len);
            len = bufferInputStream.read(buffer);

        }

        bout.flush();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        bufferInputStream.close();
        return bytes;
    }

    public static void base64StringToPDF(String base64String, String newFile) {
        try {
            byte[] bytes = decoder.decodeBuffer(base64String);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            BufferedInputStream bin = new BufferedInputStream(bais);
            File file = new File(newFile);


            FileOutputStream fout = new FileOutputStream(file);
            BufferedOutputStream bout = new BufferedOutputStream(fout);
            byte[] buffers = new byte[1024];
            int len = bin.read(buffers);
            while (len != -1) {
                bout.write(buffers, 0, len);
                len = bin.read(buffers);
            }
            bout.flush();
            bout.close();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
