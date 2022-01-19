package com.date.utils;

/**
 * to do
 *
 * @author Hj
 * @date 2021/8/6
 */

import java.io.File;
import java.io.IOException;

//�г�File��һЩ���ò���
public class TraversalUtil {
    /**
     * ����ָ��Ŀ¼�£���������Ŀ¼���������ļ�����ɾ���� lastUpdated ��β���ļ�
     *
     * @param dir Ŀ¼��λ�� path
     * @throws IOException
     */
    public static void listDirectory(File dir, ConvertEncodetype convertEncodetype) throws IOException {
        if (!dir.exists())
            throw new IllegalArgumentException("Ŀ¼��" + dir + "������.");
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + " ����Ŀ¼��");
        }
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory())
                    //�ݹ�
                    listDirectory(file, convertEncodetype);
                else { // ɾ���� lastUpdated ��β���ļ�
                    String fileName = file.getName();
                    System.out.println(file.getParent() + fileName);
                    String file1 = file.getParent() + "\\" + fileName;
                    //�Ʋ�ı�������
                    String encodetype = EncodeUtils.getFileEncoding(file1);
                    if (encodetype.contains("UTF-8") && convertEncodetype == ConvertEncodetype.TOGBK) {
                        //תΪgbk
                        System.out.println("Դ�ļ�����===>" + encodetype + "===>��תΪgbk");
                        EncodeUtils.handleCharsetUTF8ToGBK(file1, file1);
                    } else if (encodetype.contains("UTF-8") && convertEncodetype == ConvertEncodetype.TOUTF) {
                        System.out.println("�������UTF-8,����Ҫ��ת");
                    } else if (encodetype.contains("GB2312") && convertEncodetype == ConvertEncodetype.TOUTF) {
                        //תΪutf
                        System.out.println("Դ�ļ�����===>" + encodetype + "===>��תΪUTF8");
//                        EncodeUtils.handleCharsetGBKToUTF8(file1, file1);

                    } else if (encodetype.contains("GB2312") && convertEncodetype == ConvertEncodetype.TOGBK) {
                        System.out.println("�������GB2312,����Ҫ��ת");
                    } else {
                        System.out.println("Դ�ļ�����===>" + encodetype + "===>����????????????????");

                    }
                }
            }
        }
    }


}
