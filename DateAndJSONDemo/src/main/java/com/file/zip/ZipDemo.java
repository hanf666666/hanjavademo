package com.file.zip;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.extra.compress.CompressUtil;
import cn.hutool.extra.compress.extractor.Extractor;

/**
 * to do
 *
 * @author Hj
 * @date 2023/7/3
 */
public class ZipDemo {
    public static void main(String[] args) {

        Extractor extractor =     CompressUtil.createExtractor(
                CharsetUtil.defaultCharset(),
                FileUtil.file("D:\\ideaspace\\javaspace\\zijidemo\\hanjavademo\\DateAndJSONDemo\\src\\main\\resources\\0115687004048598_20430101.zip"));

        extractor.extract(FileUtil.file("D:\\/demo/"));


    }
}
