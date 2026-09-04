package com.nio;

/**
 * @author Hj
 * @date 2026/9/4
 */
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
@Slf4j
public class NioEchoServer {

    public static void main(String[] args) throws IOException {
        // 1. 创建 Selector（多路复用器）
        Selector selector = Selector.open();   // 关键方法：Selector.open()

        // 2. 创建 ServerSocketChannel 并绑定端口
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(8080));
        serverChannel.configureBlocking(false);   // 必须非阻塞

        // 3. 将 ServerSocketChannel 注册到 Selector，关注 ACCEPT 事件
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);  // 关键方法：register()

        System.out.println("NIO Echo Server 启动，端口 8080");

        // 4. 事件循环（Reactor 模式的核心）
        while (true) {
            // 关键方法：select() —— 阻塞直到有就绪事件
            int readyCount = selector.select();
            if (readyCount == 0) continue;

            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                keyIterator.remove(); // 防止重复处理

                // 处理 ACCEPT 事件
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel client = server.accept();
                    client.configureBlocking(false);
                    // 将客户端通道注册到 Selector，关注 READ 事件
                    client.register(selector, SelectionKey.OP_READ);  // 关键方法：register()
                    System.out.println("新连接: " + client.getRemoteAddress()+client);
                }

                // 处理 READ 事件
                if (key.isReadable()) {
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);  // 创建缓冲区
                    int bytesRead = client.read(buffer);   // 关键方法：read()
                    if (bytesRead == -1) {
                        // 客户端关闭
                        client.close();
                        key.cancel();
                        continue;
                    }
                    // 切换为读模式为写模式（flip）
                    buffer.flip();   // 关键方法：flip()
                    // 回显数据（写入客户端）
                    client.write(buffer); // 关键方法：write()
                    buffer.clear();  // 清空缓冲区准备下一次读取
                }
            }
        }
    }
}
