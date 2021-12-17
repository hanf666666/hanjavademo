package com.it.utils;

import info.monitorenter.cpdetector.io.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * to do
 *
 * @author Hj
 * @date 2021/12/16
 */
public class EncodeUtils {


    /**
     * gbk转utf-8
     *
     * @param gbkStr
     * @param utf8Str
     */
    public static void handleCharsetGBKToUTF8(String gbkStr, String utf8Str) {
        final File gbkFile = new File(gbkStr);
        final File utf8File = new File(utf8Str);
        try {
            List<String> gbkLines = FileUtils.readLines(gbkFile, "GBK");
            FileUtils.writeLines(utf8File, "UTF-8", gbkLines);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * utf-8 --> gbk
     * @param utf8Str
     * @param gbkStr
     */
    public static void handleCharsetUTF8ToGBK(String utf8Str, String gbkStr) {
        try {
            final File utf8File = new File(utf8Str);
            final File gbkFile = new File(gbkStr);
            List<String> utf8Lines = FileUtils.readLines(utf8File, "UTF-8");
            FileUtils.writeLines(gbkFile, "GBK", utf8Lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getFileEncoding(String path) throws IOException {
/*
		------------------------------------------------------------------------
		  detector是探测器，它把探测任务交给具体的探测实现类的实例完成。
		  cpDetector内置了一些常用的探测实现类，这些探测实现类的实例可以通过add方法 加进来，
          	如ParsingDetector、 JChardetFacade、ASCIIDetector、UnicodeDetector。
		  detector按照“谁最先返回非空的探测结果，就以该结果为准”的原则返回探测到的字符集编码。
		--------------------------------------------------------------------------*/
        info.monitorenter.cpdetector.io.CodepageDetectorProxy detector =
                info.monitorenter.cpdetector.io.CodepageDetectorProxy.getInstance();

/*		-------------------------------------------------------------------------
		  ParsingDetector可用于检查HTML、XML等文件或字符流的编码,构造方法中的参数用于
		  指示是否显示探测过程的详细信息，为false不显示。
		---------------------------------------------------------------------------*/

        detector.add(new info.monitorenter.cpdetector.io.ParsingDetector(false));

/*--------------------------------------------------------------------------
		  JChardetFacade封装了由Mozilla组织提供的JChardetFacade，它可以完成大多数文件的编码
		  测定。所以，一般有了这个探测器就可满足大多数项目的要求，如果你还不放心，可以
		  再多加几个探测器，比如下面的ASCIIDetector、UnicodeDetector等。
		 ---------------------------------------------------------------------------*/
        detector.add(info.monitorenter.cpdetector.io.JChardetFacade.getInstance());
        // ASCIIDetector用于ASCII编码测定
        detector.add(info.monitorenter.cpdetector.io.ASCIIDetector.getInstance());
        // UnicodeDetector用于Unicode家族编码的测定
        detector.add(info.monitorenter.cpdetector.io.UnicodeDetector.getInstance());

        java.nio.charset.Charset charset = null;
        File f = new File(path);
        try {
//			charset = detector.detectCodepage(new URI(f.getPath()).toURL());
            charset = detector.detectCodepage(f.toURL());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (charset != null) {
            //System.out.println(f.getName() + " encoding is：" + charset.name());
            return charset.name();
        } else
            //System.out.println(f.getName() + " unknown");
            return null;
    }

    /**
     * 方法三：比较准确，解决了实际问题
     *
     * @param filePath
     * @return
     */
    public static String getFileEncode(String filePath) {
        String charsetName = null;
        try {
            File file = new File(filePath);
            CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
            detector.add(new ParsingDetector(false));
            detector.add(JChardetFacade.getInstance());
            detector.add(ASCIIDetector.getInstance());
            detector.add(UnicodeDetector.getInstance());
            java.nio.charset.Charset charset = null;
            charset = detector.detectCodepage(file.toURI().toURL());
            if (charset != null) {
                charsetName = charset.name();
            } else {
                charsetName = "UTF-8";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return charsetName;
    }
}
