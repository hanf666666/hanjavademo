package com.newsfeatures.demo;

import com.itextpdf.text.pdf.*;
import com.itextpdf.text.Document;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class pdfdemo {
    public static void main(String[] args) {

        String newfile = "C:\\Users\\Win10\\Desktop\\aaa.pdf";
        try {
//            File[] files = listDirectory(new File("C:\\Users\\Win10\\Desktop\\bbbb"));
            File[] files = listDirectory(new File("C:\\Users\\Win10\\Desktop\\trwertwe"));
            for (File file : files) {
                System.out.println(file);
            }
            mergePdfFiles(files, newfile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 将多个pdf 合并成一个pdf
     *
     * @return
     */
    public static boolean mergePdfFiles( File[] files, String newfile) {
        //将 test1.pdf 与 test2.pdf中的内容 合并成 test3.pdf

        boolean retValue = false;
        Document document = null;
        try {
            document = new Document(new PdfReader(files[0].getAbsolutePath()).getPageSize(1));
            PdfCopy copy = new PdfCopy(document, new FileOutputStream(newfile));
            document.open();
            for (int i = 0; i < files.length; i++) {
                PdfReader reader = new PdfReader(files[i].getAbsolutePath());
                int n = reader.getNumberOfPages();
                for (int j = 1; j <= n; j++) {
                    document.newPage();
                    PdfImportedPage page = copy.getImportedPage(reader, j);
                    copy.addPage(page);
                }
            }
            retValue = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
        return retValue;
    }


    /**
     * 遍历指定目录下（包括其子目录）的所有文件，并删除以 lastUpdated 结尾的文件
     *
     * @param dir 目录的位置 path
     * @throws IOException
     */
    public static File[] listDirectory(File dir) throws IOException {
        if (!dir.exists())
            throw new IllegalArgumentException("目录：" + dir + "不存在.");
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + " 不是目录。");
        }
        File[] files = dir.listFiles();
        File[] files1 = new File[files.length];
        if (files != null && files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory())
                    //递归
                    listDirectory(files[i]);
                else { // 删除以 lastUpdated 结尾的文件

                    for (int j = 0; j <files1.length ; j++) {
                        String fileName = files[i].getName();
//                        if(fileName.contains("第"+j+1+"讲")){
                        if(fileName.contains("第"+(j+1)+"讲")){
                            files1[j]=files[i];
                        }
                    }
                }
            }

        }
        return files1;
    }
}
