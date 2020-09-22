package com.jzc.spring.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Date;

public class NettyClient {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap
                .group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>(){

                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new ClientServerHandler());
                    }

                });

        ChannelFuture future = bootstrap.connect("127.0.0.1", 8800).syncUninterruptibly();

        while (true) {
            Date now = new Date();
            byte[] msg = new String(now + "发送的消息").getBytes();

            future.channel().writeAndFlush(Unpooled.copiedBuffer(msg));
            Thread.sleep(1000);
        }

//        future.channel().closeFuture();
//        group.shutdownGracefully();
    }

}
