package NIO;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

public class TestNonBlockingNIO {
    @Test
    public void client() throws IOException {
        //1.获取通道
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));
        //2.切换非阻塞模式
        channel.configureBlocking(false);
        //3.分配缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //4.发送数据
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            buffer.put((LocalDateTime.now()+"\n"+str).getBytes());
            buffer.flip();
            channel.write(buffer);
            buffer.clear();
        }
        channel.close();
    }

    @Test
    public void server() throws IOException {
        //1.获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //2.切换非阻塞模式
        ssChannel.configureBlocking(false);
        //3.绑定连接
        ssChannel.bind(new InetSocketAddress(9898));
        //4.获取选择器
        Selector selector = Selector.open();
        //5.将通道注册到选择器上 并且指定监听事件
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6.轮询式获取选择器上已经准备就绪的事件
        while (selector.select() > 0) {
            //7.获取当前选择器中所有注册的监听事件
            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
            while (keys.hasNext()) {
                //8.获取准备‘就绪’的事件
                SelectionKey next = keys.next();
                //9.判断是什么事件准备就绪
                if (next.isAcceptable()) {
                    SocketChannel sChannel = ssChannel.accept();
                    //10.切换非阻塞模式
                    sChannel.configureBlocking(false);
                    //11.注册到选择器上
                    sChannel.register(selector, SelectionKey.OP_READ);
                } else if (next.isReadable()) {
                    //获取选择器上读就绪状态的通道
                    SocketChannel sChannel = (SocketChannel) next.channel();
                    //读取数据
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = sChannel.read(buf)) > 0) {
                        buf.flip();
                        System.out.println(new String(buf.array(),0,len));
                        buf.clear();
                    }
                }
                //取消选键
                keys.remove();
            }
        }



    }
}
