package com.audio;


import javax.sound.sampled.*;
import java.io.*;
import java.net.*;
/**
 * to do
 *
 * @author Hj
 * @date 2024/10/24
 */
public class AudioServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket socket = serverSocket.accept();

        // 获取音频输入流（麦克风）
        AudioFormat format = new AudioFormat(44100, 16, 2, true, false);
        DataLine.Info targetInfo = new DataLine.Info(TargetDataLine.class, format);
        if (!AudioSystem.isLineSupported(targetInfo)) {
            System.out.println("Line not supported");
            System.exit(0);
        }
        TargetDataLine targetLine = (TargetDataLine) AudioSystem.getLine(targetInfo);
        targetLine.open(format);
        targetLine.start();

        // 获取输出流（发送音频数据）
        OutputStream outputStream = socket.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead;

        while (true) {
            bytesRead = targetLine.read(buffer, 0, buffer.length);
            outputStream.write(buffer, 0, bytesRead);
        }
    }
}