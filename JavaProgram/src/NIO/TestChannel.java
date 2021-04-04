package NIO;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;

/**
 * ͨ��������Դ�ڵ��Ŀ��ڵ�����ӣ���NIO���ڸ��𻺳��������ݵĴ��䣬�����������ݣ��ͻ���������ʹ�á�
 * ��Ҫʵ���ࣺ
 *         Channel�ӿڣ�
 *              ʵ���ࣺFileChannel,SocketChannel,ServerSocketChannel,DatagramChannel
 * ��ȡͨ����
 *      getChannel();
 *
 */
public class TestChannel {
    //����ͨ������ļ����ƣ���ֱ�ӻ�������
    @Test
    public void test1() throws Exception{
        //1.����ͨ������ļ��ĸ���
        FileInputStream fileInputStream = new FileInputStream("1.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("2.jpg");
        //��ȡͨ��
        FileChannel inchannel = fileInputStream.getChannel();
        FileChannel outchannel = fileOutputStream.getChannel();
        //���仺����
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //��ͨ��������д�뻺����
        while (inchannel.read(buf) != -1) {
            buf.flip();//�л���ģʽ
            outchannel.write(buf);
            buf.clear();//��ջ�����

        }
        outchannel.close();
        inchannel.close();
        fileOutputStream.close();
        fileInputStream.close();
        //��������������д��ͨ��
    }

    @Test  //����ֱ�ӻ���������ļ�����
    public void test2() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("E:\\���\\���2.jpg"), StandardOpenOption.READ);
        //StandardOpenOption.CREATE_NEW����ļ����ھͱ��������ھʹ���
        FileChannel outChannel = FileChannel.open(Paths.get("E:\\���\\NIO���2.jpg"),
                StandardOpenOption.WRITE,
                StandardOpenOption.READ,
                StandardOpenOption.CREATE_NEW);
        //�ڴ�ӳ���ļ�
        MappedByteBuffer inMap = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMap = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
        //ֱ�ӶԻ�������д����
        byte[] bytes = new byte[inMap.limit()];
        inMap.get(bytes);
        outMap.put(bytes);
        outChannel.close();
        inChannel.close();
    }

    @Test
    public void test3() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("E:\\���\\���2.jpg"), StandardOpenOption.READ);
        //StandardOpenOption.CREATE_NEW����ļ����ھͱ��������ھʹ���
        FileChannel outChannel = FileChannel.open(Paths.get("E:\\���\\NIO���2.jpg"),
                StandardOpenOption.WRITE,
                StandardOpenOption.READ,
                StandardOpenOption.CREATE_NEW);
        inChannel.transferTo(0, inChannel.size(), outChannel);
        outChannel.close();
        inChannel.close();
    }

    /**
     * ��ɢ�;ۼ�
     * @throws Exception
     */
    @Test
    public void test4() throws Exception {
        RandomAccessFile raf = new RandomAccessFile("E:\\���\\���2.jpg","rw");
        //��ȡͨ��
        FileChannel channel = raf.getChannel();
        //����ָ����С�Ļ�����
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
        //��ɢ��ȡ
        ByteBuffer[] bfs = {byteBuffer,byteBuffer1};
        channel.read(bfs);
        for (ByteBuffer bf : bfs) {
            bf.flip();
        }
        System.out.println(new String(bfs[0].array(),0,bfs[0].limit()));
        System.out.println("------------");
        System.out.println(new String(bfs[1].array(),0,bfs[0].limit()));

        //�ۼ�д��
        RandomAccessFile raf2 = new RandomAccessFile("E:\\���\\���2.jpg", "rw");
        FileChannel channel1 = raf2.getChannel();
        channel1.write(bfs);
    }

    //�ַ���
    @Test
    public void test5() {
        Map<String, Charset> map = Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> entries = map.entrySet();
        for (Map.Entry<String, Charset> entry : entries) {
            System.out.println(entry.getKey()+"=="+entry.getValue());
        }
    }

    @Test
    public void test6() throws CharacterCodingException {
        Charset gbk = Charset.forName("GBK");
        //��ȡ�������ͽ�����
        CharsetEncoder encoder = gbk.newEncoder();
        CharsetDecoder decoder = gbk.newDecoder();
        CharBuffer cBuf = CharBuffer.allocate(1024);
        cBuf.put("ţ��");
        cBuf.flip();
        ByteBuffer buf1 = encoder.encode(cBuf);//����
        //����
        buf1.flip();
        CharBuffer buf2 = decoder.decode(buf1);
        System.out.println(buf2.length());
    }

}
