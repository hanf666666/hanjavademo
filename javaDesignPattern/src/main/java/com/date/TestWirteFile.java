package com.date;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * �������ļ���д�ļ�
 *
 * @author lenovo
 *
 */
public class TestWirteFile {

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String sContent = "2015���˫ʮһ����Ƿǳ���!";
        String sDestFile = "E:/myWrite.txt";
        File destFile = new File(sDestFile);
        if (!destFile.exists()) {
            destFile.createNewFile();
        }

        // 1.���ļ�д������
        // writeByFileWrite(sDestFile, sContent);

        // 2.FileOutputStream���ļ�д������
        // writeByFileWrite(sDestFile, sContent);

        // 2.OutputStreamWriter���ļ�д������
//        writeByOutputStreamWrite(sDestFile, sContent);
    }

    /**
     * ��FileWrite���ļ�д������
     *
     * @param _destFile
     * @throws IOException
     */
    public static void writeByFileWrite(String _sDestFile, String _sContent)
            throws IOException {
        FileWriter fw = null;
        try {
            fw = new FileWriter(_sDestFile);
            fw.write(_sContent);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fw != null) {
                fw.close();
                fw = null;
            }
        }
    }

    /**
     * ��FileOutputStream���ļ�д������
     *
     * @param _destFile
     * @throws IOException
     */
    public static void writeByFileOutputStream(String _sDestFile,
                                               String _sContent) throws IOException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(_sDestFile);
            fos.write(_sContent.getBytes());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fos != null) {
                fos.close();
                fos = null;
            }
        }
    }

    /**
     * ��OutputStreamWrite���ļ�д������
     *
     * @param _destFile
     * @throws IOException
     */
    public static void writeByOutputStreamWrite(String _sDestFile,
                                                String _sContent) throws IOException {
        OutputStreamWriter os = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(_sDestFile);
            os = new OutputStreamWriter(fos, "UTF-8");
            os.write(_sContent);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (os != null) {
                os.close();
                os = null;
            }
            if (fos != null) {
                fos.close();
                fos = null;
            }

        }
    }

}
