package com.scandemo.xinglian;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.List;

/**
 * 查版本
 *
 * @author Hj
 * @date 2021/8/6
 */
public class ScanDemo1 {

    public static void main(String[] args) {
        System.out.println(DateUtil.date().toString("yyyyMMddHHmmssSSS"));

//        String line2 = " parkOrder.setStatus(OrderStatusEnum.PAID.getValue());";
//        if (
//                line2.contains("parkOrder.setStatus(")
//                        && (line2.contains("OrderStatusEnum.PAID") || line2.contains("3"))
////                        &&(file.getPath().contains("road"))
//
//
//        ) {
//            System.out.println(line2);
//        }


        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\xinlianzhilianwang", new FileFilter() {
//        List<File> files = FileUtil.loopFiles("D:\\ideaspace\\javaspace\\meitikeji", new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getPath().indexOf(".git") > -1
                        || pathname.getPath().indexOf("sql") > -1
                        || pathname.getPath().indexOf("target") > -1
                        || pathname.getPath().indexOf(".idea") > -1
//                        || pathname.getPath().indexOf(".java") > -1
//                        || pathname.getPath().indexOf("txprod") == -1

                ) {
                    //选中就不搜索
                    return false;


                }
                return true;

            }
        });
        for (File file : files) {
//            List<String> stringList = FileUtil.readLines(file, Charset.defaultCharset());
            List<String> stringList = FileUtil.readLines(file, "UTF-8");
            HashMap<Integer, String> lineMap = new HashMap<>();
            int lineNum = 0;
            for (int i = 0; i < stringList.size(); i++) {
                String line = stringList.get(i);
//                if (line.contains("pushArrearsOrderToCzEtc") ) {
//                if (line.contains("getIsShowArrear") ) {

                if (line.contains("IdentifierGenerator") ) {
//                if (line.contains("strategy/assistancePay") ) {
//                if (line.contains("etc/pay/push") ) {
                    lineNum++;
                }

                if (lineNum >= 1 && lineNum <= 1) {
                    if(lineNum==1){
                        System.out.println(file.getPath());
                    }
                    System.out.println(line);
                    System.out.println("=============================================================================================================");
                    lineNum++;

                }else {
                    lineNum=0;
                }

            }

        }

    }


}


