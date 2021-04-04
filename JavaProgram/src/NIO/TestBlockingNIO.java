package NIO;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 一。使用NIO完成网络通信的 三个核心
 *    1.通道：负责连接
 *    2.缓冲区：负责数据的存取
 *    3.选择器：是SelectableChannel的多路复用器，用于监控SelectableChannel状况的
 */
public class TestBlockingNIO {
    @Test
    public void client() throws IOException {
        //获取通道
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9562));
        FileChannel inChannel = FileChannel.open(Paths.get("E:\\悟空\\悟空2.jpg"), StandardOpenOption.READ);
        //缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (inChannel.read(buffer) != -1) {
            buffer.flip();
            channel.write(buffer);
            buffer.clear();
        }
        //关闭
        inChannel.close();
        channel.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        FileChannel f = FileChannel.open(Paths.get("E:\\悟空\\悟空2(网络编程NIO).jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        //绑定连接
        channel.bind(new InetSocketAddress("127.0.0.1",8456));
        //获取客户端连接1
        SocketChannel accept = channel.accept();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //接收客户端数据保存到本地
        while (accept.read(buffer) != -1) {
            buffer.flip();
            f.write(buffer);
            buffer.clear();
        }
        accept.close();
        f.close();
        channel.close();
    }
}
