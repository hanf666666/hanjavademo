package com.utils;

/**
 * to do
 *
 * @author Hj
 * @date 2021/8/6
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//�г�File��һЩ���ò���
public class TraversalUtil {
    /**
     * @throws IOException
     */
    public static void traversalDirectory(File dir, List<File> fileList) throws IOException {
        if (!dir.exists())
            throw new IllegalArgumentException("Ŀ¼��" + dir + "������.");
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + " ����Ŀ¼��");
        }
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                fileList.add(file);
                if (file.isDirectory())
                    //�ݹ�
                    traversalDirectory(file, fileList);

            }
        }
    }


    public static void main(String[] args) {
        String fileStr = "D:\\ideaspace\\javazispace\\hanjavademo\\mvnClean\\src\\main\\java\\com\\";
        List<File> fileList = new ArrayList<>();
        try {
            TraversalUtil.traversalDirectory(new File(fileStr), fileList);
            for (int i = fileList.size()-1; i >= 0; i--) {
                System.out.println(fileList.get(i));

            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
