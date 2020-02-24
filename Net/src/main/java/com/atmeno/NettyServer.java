package com.atmeno;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

import java.nio.channels.ServerSocketChannel;

public class NettyServer {

    public NettyServer(int port) throws InterruptedException {
        open(port);
    }

    private void open(int port) throws InterruptedException {
        ServerBootstrap bootstrap = new ServerBootstrap();
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        bootstrap.group(bossGroup,workGroup)
                .channel(NioServerSocketChannel.class)
                .localAddress(port)                                                 //设置监听端口
                .childOption(ChannelOption.SO_KEEPALIVE,false)              //默认两小时
                .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                .childHandler(new ChannelInitializer<SocketChannel>()
        {
            //有连接到达时会创建一个channel
            protected void initChannel(SocketChannel ch) throws Exception
            {
                //ChannelPipeline，Netty处理请求的责任链，是一个ChannelHandler的链表
                //ch.pipeline().addLast(new ProtobufDecoder());
                ch.pipeline().addLast(new ProtobufEncoder());
                // pipeline管理channel中的Handler
                // 在channel队列中添加一个handler来处理业务
                //ch.pipeline().addLast("serverHandler", serverHandler);
            }
        });
        // 6 开始绑定server
        // 通过调用sync同步方法阻塞直到绑定成功

        ChannelFuture channelFuture = bootstrap.bind().sync();

        // 7 监听通道关闭事件
        // 应用程序会一直等待，直到channel关闭
        ChannelFuture closeFuture=  channelFuture.channel().closeFuture();
        closeFuture.sync();
    }
}
