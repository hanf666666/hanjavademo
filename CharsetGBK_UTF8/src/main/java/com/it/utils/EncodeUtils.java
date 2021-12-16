package com.it.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/16
 */
public class EncodeUtils {
    public static void handleCharsetGBKToUTF8(File gbkFile, File utf8File) {
        try {
            List<String> gbkLines =  FileUtils.readLines(gbkFile, "GBK");
            FileUtils.writeLines(utf8File, "UTF-8", gbkLines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
