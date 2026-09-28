package com.flink;

import java.io.PrintWriter;
import java.net.Socket;

public class SocketTestClient {

    public static void main(String[] args) throws Exception {

        try (Socket socket = new Socket("127.0.0.1", 9999);
             PrintWriter writer = new PrintWriter(
                     socket.getOutputStream(), true)) {

            writer.println("apple,1,2026-09-25 16:00:01");
            Thread.sleep(1000);

            writer.println("apple,2,2026-09-25 16:00:05");
            Thread.sleep(1000);

            writer.println("banana,3,2026-09-25 16:00:10");
            Thread.sleep(1000);

            writer.println("banana,5,2026-09-25 16:00:20");
            Thread.sleep(1000);

            // 推动 Watermark，让 16:00~16:01 窗口触发
            writer.println("test,1,2026-09-25 16:01:31");

            System.out.println("测试数据发送完成");
        }
    }
}
