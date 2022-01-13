package com.date.main;

import com.date.utils.ConvertEncodetype;
import com.date.utils.TraversalUtil;

import java.io.File;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/16
 */
public class demo01 {
    public static void main(String[] args) {
        final String file1 = "D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo\\CharsetGBK_UTF8\\src\\main\\java\\com\\it\\data";
        try {
//            TraversalUtil.listDirectory(new File(file1), ConvertEncodetype.TOUTF);
            TraversalUtil.listDirectory(new File(file1), ConvertEncodetype.TOGBK);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
