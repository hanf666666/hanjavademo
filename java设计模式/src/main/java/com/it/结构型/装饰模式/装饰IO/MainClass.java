package com.it.结构型.装饰模式.装饰IO;

import java.io.*;

import static com.oracle.jrockit.jfr.ContentType.Bytes;

public class MainClass {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("fdas"));

           // ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new ByteArrayInputStream(new B);
            new PipedInputStream();
            DataInputStream is = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream("")));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
