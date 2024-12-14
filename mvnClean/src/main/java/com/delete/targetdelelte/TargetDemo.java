package com.delete.mvnclean;

import com.utils.TraversalUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * to do
 *
 * @author Hj
 * @date 2021/8/6
 */
public class TargetDemo {

    public static void main(String[] args) throws IOException {

        final Thread thread1 = new Thread() {
            @Override
            public void run() {
                super.run();
                try {

                    final ArrayList<File> fileArrayList = new ArrayList<>();
//                    final String rootFileStr = "D:\\ideaspace\\javaspace";
                    final String rootFileStr = "D:\\ideaspace\\javaspace\\";
                    //
                    TraversalUtil.traversalDirectory(new File(rootFileStr), fileArrayList);
                    fileArrayList.forEach(file -> {
                        String fileName = file.getName();

                        boolean isLastupdated = fileName.toLowerCase().endsWith("jar");
                        boolean isLastupdated2 = fileName.toLowerCase().endsWith(".jar.original");
                        boolean isTarget = file.getAbsolutePath().contains("target");

                        if ((isLastupdated||isLastupdated2) && isTarget) {
                            boolean is_delete = true;
                             is_delete = file.delete();
                            System.out.println("要删的文件" + file.getName() + "   " + is_delete);
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };


        thread1.start();


    }


}
