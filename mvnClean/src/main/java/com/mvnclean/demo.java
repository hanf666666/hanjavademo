package com.mvnclean;

import com.utils.util;

import java.io.File;
import java.io.IOException;

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
                    // ָ��maven�ı��زֿ�
                    util.listDirectory(new File("E:\\maven\\Maven_Repositorydashuju"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        final Thread thread2 = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    // ָ��maven�ı��زֿ�
                    util.listDirectory(new File("E:\\maven\\Maven_Repositorydashuju4"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
//        util.listDirectory(new File("E:\\maven\\Maven_Repositorydashuju"));
//        util.listDirectory(new File("E:\\maven\\Maven_Repositorydashuju4"));
        thread1.start();
        thread2.start();


    }


}
