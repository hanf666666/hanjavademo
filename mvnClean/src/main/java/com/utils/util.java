package com.utils;

/**
 * to do
 * ��ʱ
 * @see com.utils.TraversalUtil �滻
 * @author Hj
 * @date 2021/8/6
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//�г�File��һЩ���ò���
@Deprecated
public class util {
    /**
     * ����ָ��Ŀ¼�£���������Ŀ¼���������ļ�����ɾ���� lastUpdated ��β���ļ�
     * @param dir Ŀ¼��λ�� path
     * @throws IOException
     */
    public static void listDirectory(File dir) throws IOException {
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
                    listDirectory(file);
                else{ // ɾ���� lastUpdated ��β���ļ�
                    String fileName = file.getName();
                    boolean isLastupdated = fileName.toLowerCase().endsWith("lastupdated");
                    if (isLastupdated){
                        boolean is_delete = file.delete();
                        System.out.println("ɾ�����ļ��� => " + file.getName() + "  || �Ƿ�ɾ���ɹ��� ==> " + is_delete);
                    }
                }
            }
        }
    }




}
