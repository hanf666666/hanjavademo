package com.nio;

/**
 * @author Hj
 * @date 2026/9/4
 */
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
@Slf4j
public class NioEchoClient {

    public static void main(String[] args) throws IOException {
        // 1. 打开 SocketChannel 并连接到服务器
        SocketChannel client = SocketChannel.open();          // 关键方法：open()
        client.connect(new InetSocketAddress("localhost", 8080)); // 关键方法：connect()

        System.out.println("连接到服务器，开始发送消息...");

        // 2. 准备要发送的数据
        String message = "Hello, NIO!";
        ByteBuffer writeBuffer = ByteBuffer.wrap(message.getBytes()); // 直接用 wrap 创建

        // 3. 发送数据
        client.write(writeBuffer);   // 关键方法：write()
        System.out.println("发送: " + message);

        // 4. 接收回显（服务器会原样返回）
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        int bytesRead = client.read(readBuffer);  // 关键方法：read()
        if (bytesRead > 0) {
            readBuffer.flip();        // 关键方法：flip()，转为读模式
            byte[] data = new byte[readBuffer.remaining()];
            readBuffer.get(data);
            System.out.println("收到回显: " + new String(data));
        }

        // 5. 关闭连接
        client.close();
    }
}
