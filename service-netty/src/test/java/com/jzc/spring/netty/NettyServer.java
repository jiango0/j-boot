package com.jzc.spring.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {

    public static void main(String[] args) throws Exception {

        ServerBootstrap serverBootstrap = new ServerBootstrap();

        EventLoopGroup boor = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();

        serverBootstrap
                .group(boor, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new NettyServerHandler());
                    }

                });

        ChannelFuture future = serverBootstrap.bind(8800).sync();
        future.channel().closeFuture().sync();
        boor.shutdownGracefully();
        worker.shutdownGracefully();

    }

}
