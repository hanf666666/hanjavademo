package com.file.zip;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.ZipUtil;
import cn.hutool.extra.compress.CompressUtil;
import cn.hutool.extra.compress.extractor.Extractor;

import java.io.File;

/**
 * to do
 *
 * @author Hj
 * @date 2023/7/3
 */
public class ZipDemo2 {
    public static void main(String[] args) {

       String fileName= "D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo\\DateAndJSONDemo\\src\\main\\resources\\0115687004048598_20430101.zip";

        //��test.zip��ѹ��e:\\aaaĿ¼�£����ؽ�ѹ����Ŀ¼
        File unzip = ZipUtil.unzip(fileName, "D:\\/demo/");


    }
}
