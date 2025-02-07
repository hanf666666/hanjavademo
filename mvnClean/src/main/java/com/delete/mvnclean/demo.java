package com.delete.targetdelelte;

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
public class demo {

    public static void main(String[] args) throws IOException {

        final Thread thread1 = new Thread() {
            @Override
            public void run() {
                super.run();
                try {

                    final ArrayList<File> fileArrayList = new ArrayList<>();
                    final String rootFileStr = "E:\\maven\\Maven_Repository";
                    // Maven_Repository
                    TraversalUtil.traversalDirectory(new File(rootFileStr),fileArrayList);
                    fileArrayList.forEach(file -> {
                        String fileName = file.getName();
                        boolean isLastupdated = fileName.toLowerCase().endsWith("lastupdated");
                        if (isLastupdated){
                            boolean is_delete = file.delete();
                            System.out.println("Maven_Repository" + file.getName() + "Maven_Repository" + is_delete);
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        final Thread thread2 = new Thread() {
            @Override
            public void run() {
                super.run();
                final ArrayList<File> fileArrayList = new ArrayList<>();
                final String rootFileStr = "E:\\maven\\Maven_Repositorydashuju4";
                // ???maven???????
                try {
                    TraversalUtil.traversalDirectory(new File(rootFileStr),fileArrayList);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                fileArrayList.forEach(file -> {
                    String fileName = file.getName();
                    boolean isLastupdated = fileName.toLowerCase().endsWith("lastupdated");
                    if (isLastupdated){
                        boolean is_delete = file.delete();
                        System.out.println("Maven_Repositorydashuju4 => " + file.getName() + "  || Maven_Repositorydashuju4 ==> " + is_delete);
                    }
                });
            }
        };
//        util.listDirectory(new File("E:\\maven\\Maven_Repositorydashuju"));
//        util.listDirectory(new File("E:\\maven\\Maven_Repositorydashuju4"));
        thread1.start();
        thread2.start();


    }


}
