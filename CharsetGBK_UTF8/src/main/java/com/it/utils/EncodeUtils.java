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
     * gbkתutf-8
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
		  detector��̽����������̽�����񽻸������̽��ʵ�����ʵ����ɡ�
		  cpDetector������һЩ���õ�̽��ʵ���࣬��Щ̽��ʵ�����ʵ������ͨ��add���� �ӽ�����
          	��ParsingDetector�� JChardetFacade��ASCIIDetector��UnicodeDetector��
		  detector���ա�˭���ȷ��طǿյ�̽���������Ըý��Ϊ׼����ԭ�򷵻�̽�⵽���ַ������롣
		--------------------------------------------------------------------------*/
        info.monitorenter.cpdetector.io.CodepageDetectorProxy detector =
                info.monitorenter.cpdetector.io.CodepageDetectorProxy.getInstance();

/*		-------------------------------------------------------------------------
		  ParsingDetector�����ڼ��HTML��XML���ļ����ַ����ı���,���췽���еĲ�������
		  ָʾ�Ƿ���ʾ̽����̵���ϸ��Ϣ��Ϊfalse����ʾ��
		---------------------------------------------------------------------------*/

        detector.add(new info.monitorenter.cpdetector.io.ParsingDetector(false));

/*--------------------------------------------------------------------------
		  JChardetFacade��װ����Mozilla��֯�ṩ��JChardetFacade����������ɴ�����ļ��ı���
		  �ⶨ�����ԣ�һ���������̽�����Ϳ�����������Ŀ��Ҫ������㻹�����ģ�����
		  �ٶ�Ӽ���̽���������������ASCIIDetector��UnicodeDetector�ȡ�
		 ---------------------------------------------------------------------------*/
        detector.add(info.monitorenter.cpdetector.io.JChardetFacade.getInstance());
        // ASCIIDetector����ASCII����ⶨ
        detector.add(info.monitorenter.cpdetector.io.ASCIIDetector.getInstance());
        // UnicodeDetector����Unicode�������Ĳⶨ
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
            //System.out.println(f.getName() + " encoding is��" + charset.name());
            return charset.name();
        } else
            //System.out.println(f.getName() + " unknown");
            return null;
    }

    /**
     * ���������Ƚ�׼ȷ�������ʵ������
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
