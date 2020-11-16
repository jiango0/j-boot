package com.jzc.spring.netty.test.buffer;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScatteringAndGatheringTest {

    public static void main(String[] args) throws Exception {
        //使用 ServerSocketChannel 网络
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);
        //绑定端口到socket，并启动
        serverSocketChannel.socket().bind(inetSocketAddress);

        //创建buffer数据
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        //等待客户端连接
        SocketChannel socketChannel = serverSocketChannel.accept();
        int messageLength = 8; //最大长度

        //循环读取
        while (true) {
            int byteRead = 0;
            while (byteRead < messageLength) {
                long read = socketChannel.read(byteBuffers);
                byteRead += read;
                System.out.println("byteRead=" + byteRead);
                //使用流打印
                Arrays.stream(byteBuffers)
                        .map(byteBuffer -> "postion=" + byteBuffer.position() + "limit=" + byteBuffer.limit())
                        .forEach(System.out::println);
            }

            //将所有的buffer进行翻转
            Arrays.asList(byteBuffers).forEach(ByteBuffer::flip);

            long byteWirte = 0;
            while (byteWirte < messageLength) {
                long write = socketChannel.write(byteBuffers);
                byteWirte += write;
            }

            //将所有的buffer复位
            Arrays.asList(byteBuffers).forEach(ByteBuffer::clear);

            System.out.println("byteRead=" + byteRead + " byteWirte=" + byteWirte + " messageLength=" + messageLength);
        }


    }


}
