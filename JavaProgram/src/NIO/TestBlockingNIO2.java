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

public class TestBlockingNIO2 {

    @Test
    public void client() throws IOException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        FileChannel inChannel = FileChannel.open(Paths.get("E:\\���\\���2.jpg"), StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (inChannel.read(buffer) != 1) {
            buffer.flip();//������
            channel.write(buffer);
            buffer.clear();
        }
        channel.shutdownOutput();
        //���շ���˵ķ���
        int len= 0;
        while ((len = channel.read(buffer)) != -1) {
            buffer.flip();
            System.out.println(new String(buffer.array(),0,len));
            buffer.clear();
        }
        inChannel.close();
        channel.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocketChannel c = ServerSocketChannel.open();
        FileChannel fChannel = FileChannel.open(Paths.get("E:\\���\\���2(������).jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        c.bind(new InetSocketAddress(9898));
        SocketChannel achannel = c.accept();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (achannel.read(buffer) != -1) {
            buffer.flip();
            fChannel.write(buffer);
            buffer.clear();
        }
        //���ͷ������ͻ���
        buffer.put("����˽��ճɹ��ˣ�".getBytes());
        buffer.flip();
        achannel.write(buffer);

        achannel.close();
        fChannel.close();
        c.close();

    }
}
