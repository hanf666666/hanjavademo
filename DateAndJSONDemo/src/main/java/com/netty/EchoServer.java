package com.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Netty Echo 服务端 - 接收消息并原样返回
 */
@Slf4j
public class EchoServer {

    public static void main(String[] args) throws Exception {
        // ① 创建两个线程组：bossGroup 负责接收连接，workerGroup 负责处理读写
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);   // 通常1个线程即可
        EventLoopGroup workerGroup = new NioEventLoopGroup();  // 默认 CPU核数*2

        try {
            // ② 服务端引导类
            ServerBootstrap server = new ServerBootstrap();
            server.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)      // 使用 NIO 传输
                    .option(ChannelOption.SO_BACKLOG, 128)      // 连接队列大小
                    .childOption(ChannelOption.SO_KEEPALIVE, true) // TCP keepalive
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            ChannelPipeline pipeline = ch.pipeline();
                            // 1. 【新增】第一步：解决粘包拆包（以换行符作为消息结束标志）
                            // 1024 表示单条消息最大长度，防止内存溢出
                            pipeline.addLast(new LineBasedFrameDecoder(1024));
                            // ③ 添加编解码器（字符串形式，方便测试）
                            pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
                            pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
                            // ④ 添加自定义的业务处理器（Echo逻辑）
                            pipeline.addLast(new EchoServerHandler());
                        }
                    });

            // ⑤ 绑定端口，启动服务
            ChannelFuture future = server.bind(8888).sync();
            log.info("EchoServer 启动 启动成功，监听端口: 8888");

            // 等待服务器关闭
            future.channel().closeFuture().sync();
        } finally {
            // 优雅关闭线程组
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}

/**
 * 自定义处理器：收到消息后直接原样写回
 */
@Slf4j
class EchoServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) {
        log.info("收到客户端消息: " + msg);
        // 直接写回（原样回显）
        ctx.writeAndFlush("【服务端回显】" + msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
