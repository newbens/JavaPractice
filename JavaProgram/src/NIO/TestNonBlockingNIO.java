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
        //1.��ȡͨ��
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));
        //2.�л�������ģʽ
        channel.configureBlocking(false);
        //3.���仺����
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //4.��������
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
        //1.��ȡͨ��
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //2.�л�������ģʽ
        ssChannel.configureBlocking(false);
        //3.������
        ssChannel.bind(new InetSocketAddress(9898));
        //4.��ȡѡ����
        Selector selector = Selector.open();
        //5.��ͨ��ע�ᵽѡ������ ����ָ�������¼�
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6.��ѯʽ��ȡѡ�������Ѿ�׼���������¼�
        while (selector.select() > 0) {
            //7.��ȡ��ǰѡ����������ע��ļ����¼�
            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
            while (keys.hasNext()) {
                //8.��ȡ׼�������������¼�
                SelectionKey next = keys.next();
                //9.�ж���ʲô�¼�׼������
                if (next.isAcceptable()) {
                    SocketChannel sChannel = ssChannel.accept();
                    //10.�л�������ģʽ
                    sChannel.configureBlocking(false);
                    //11.ע�ᵽѡ������
                    sChannel.register(selector, SelectionKey.OP_READ);
                } else if (next.isReadable()) {
                    //��ȡѡ�����϶�����״̬��ͨ��
                    SocketChannel sChannel = (SocketChannel) next.channel();
                    //��ȡ����
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = sChannel.read(buf)) > 0) {
                        buf.flip();
                        System.out.println(new String(buf.array(),0,len));
                        buf.clear();
                    }
                }
                //ȡ��ѡ��
                keys.remove();
            }
        }



    }
}
