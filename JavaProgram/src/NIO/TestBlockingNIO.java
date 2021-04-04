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
 * һ��ʹ��NIO�������ͨ�ŵ� ��������
 *    1.ͨ������������
 *    2.���������������ݵĴ�ȡ
 *    3.ѡ��������SelectableChannel�Ķ�·�����������ڼ��SelectableChannel״����
 */
public class TestBlockingNIO {
    @Test
    public void client() throws IOException {
        //��ȡͨ��
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9562));
        FileChannel inChannel = FileChannel.open(Paths.get("E:\\���\\���2.jpg"), StandardOpenOption.READ);
        //������
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (inChannel.read(buffer) != -1) {
            buffer.flip();
            channel.write(buffer);
            buffer.clear();
        }
        //�ر�
        inChannel.close();
        channel.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        FileChannel f = FileChannel.open(Paths.get("E:\\���\\���2(������NIO).jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        //������
        channel.bind(new InetSocketAddress("127.0.0.1",8456));
        //��ȡ�ͻ�������1
        SocketChannel accept = channel.accept();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //���տͻ������ݱ��浽����
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
