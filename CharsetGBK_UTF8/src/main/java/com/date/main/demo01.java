package com.date.main;

import com.date.utils.ConvertEncodetype;
import com.date.utils.TraversalUtil;

import java.io.File;

/**
 * to do
 * 所有项目统一用utf-8
 * 一定注意编码问题,这个都没用用
 * @author Hj
 * @date 2021/12/16
 */
public class demo01 {
    public static void main(String[] args) {
        final String file1 = "D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo\\hbase_Set";
        try {
//            TraversalUtil.listDirectory(new File(file1), ConvertEncodetype.TOUTF);
            TraversalUtil.listDirectory(new File(file1), ConvertEncodetype.TOGBK);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
