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
                // 处理 READ 事件
                if (key.isReadable()) {
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int bytesRead = client.read(buffer);

                    if (bytesRead == -1) {
                        client.close();
                        key.cancel();
                        System.out.println("客户端断开连接");
                        continue;
                    }

                    // 切换到读模式，准备读取数据
                    buffer.flip();

                    // ========== 新增：打印读取到的内容 ==========
                    byte[] data = new byte[buffer.remaining()];
                    buffer.get(data);
                    String received = new String(data);
                    System.out.println("服务端收到: " + received);

                    // ========== 关键修复：循环写入，确保全部发完 ==========
                    buffer.rewind(); // 重置 position 到 0，准备重新发送
                    while (buffer.hasRemaining()) {
                        client.write(buffer); // 非阻塞下循环直到全部写入
                    }

                    buffer.clear();
                }
            }
        }
    }
}
