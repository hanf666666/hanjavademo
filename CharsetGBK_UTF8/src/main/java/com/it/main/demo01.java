package com.it.main;

import com.it.utils.EncodeUtils;
import com.it.utils.TraversalUtil;

import java.io.File;
import java.io.IOException;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/16
 */
public class demo01 {
    public static void main(String[] args) {
        final String file1 = "D:\\ideaspace\\sourcecodespace\\spring-framework";
        try {
            TraversalUtil.listDirectory(new File(file1));


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
