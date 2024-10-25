package com.audio;

/**
 * to do
 *
 * @author Hj
 * @date 2024/10/24
 */
import lombok.extern.slf4j.Slf4j;

import javax.sound.sampled.*;
import java.io.*;
import java.net.*;
@Slf4j
public class AudioClient {
    public static void main(String[] args) throws IOException, LineUnavailableException {
        Socket socket = new Socket("localhost", 12345);

        // ��ȡ��Ƶ��������������Ƶ���ݣ�
        InputStream inputStream = socket.getInputStream();

        // ��ȡ��Ƶ���������������
        AudioFormat format = new AudioFormat(44100, 16, 2, true, false);
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
        SourceDataLine dataLine = (SourceDataLine) AudioSystem.getLine(info);
        dataLine.open(format);
        dataLine.start();

        byte[] buffer = new byte[4096];
        int bytesRead;

        while (true) {
            bytesRead = inputStream.read(buffer, 0, buffer.length);
            log.info("bytesRead = {}", bytesRead);
            log.info("buffer = {}", buffer);
            if (bytesRead == -1) break;
            dataLine.write(buffer, 0, bytesRead);
        }

        dataLine.drain();
        dataLine.close();
        socket.close();
    }
}