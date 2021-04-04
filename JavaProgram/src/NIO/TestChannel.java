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
 * 通道：用于源节点和目标节点的连接，在NIO用于负责缓冲区中数据的传输，本身不储存数据，和缓冲区搭配使用。
 * 主要实现类：
 *         Channel接口：
 *              实现类：FileChannel,SocketChannel,ServerSocketChannel,DatagramChannel
 * 获取通道：
 *      getChannel();
 *
 */
public class TestChannel {
    //利用通道完成文件复制（非直接缓冲区）
    @Test
    public void test1() throws Exception{
        //1.利用通道完成文件的复制
        FileInputStream fileInputStream = new FileInputStream("1.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("2.jpg");
        //获取通道
        FileChannel inchannel = fileInputStream.getChannel();
        FileChannel outchannel = fileOutputStream.getChannel();
        //分配缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //将通道的数据写入缓冲区
        while (inchannel.read(buf) != -1) {
            buf.flip();//切换读模式
            outchannel.write(buf);
            buf.clear();//清空缓冲区

        }
        outchannel.close();
        inchannel.close();
        fileOutputStream.close();
        fileInputStream.close();
        //将缓冲区的数据写入通道
    }

    @Test  //利用直接缓冲区完成文件复制
    public void test2() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("E:\\悟空\\悟空2.jpg"), StandardOpenOption.READ);
        //StandardOpenOption.CREATE_NEW如果文件存在就报错，不存在就创建
        FileChannel outChannel = FileChannel.open(Paths.get("E:\\悟空\\NIO悟空2.jpg"),
                StandardOpenOption.WRITE,
                StandardOpenOption.READ,
                StandardOpenOption.CREATE_NEW);
        //内存映射文件
        MappedByteBuffer inMap = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMap = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
        //直接对缓冲区读写操作
        byte[] bytes = new byte[inMap.limit()];
        inMap.get(bytes);
        outMap.put(bytes);
        outChannel.close();
        inChannel.close();
    }

    @Test
    public void test3() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("E:\\悟空\\悟空2.jpg"), StandardOpenOption.READ);
        //StandardOpenOption.CREATE_NEW如果文件存在就报错，不存在就创建
        FileChannel outChannel = FileChannel.open(Paths.get("E:\\悟空\\NIO悟空2.jpg"),
                StandardOpenOption.WRITE,
                StandardOpenOption.READ,
                StandardOpenOption.CREATE_NEW);
        inChannel.transferTo(0, inChannel.size(), outChannel);
        outChannel.close();
        inChannel.close();
    }

    /**
     * 分散和聚集
     * @throws Exception
     */
    @Test
    public void test4() throws Exception {
        RandomAccessFile raf = new RandomAccessFile("E:\\悟空\\悟空2.jpg","rw");
        //获取通道
        FileChannel channel = raf.getChannel();
        //分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
        //分散读取
        ByteBuffer[] bfs = {byteBuffer,byteBuffer1};
        channel.read(bfs);
        for (ByteBuffer bf : bfs) {
            bf.flip();
        }
        System.out.println(new String(bfs[0].array(),0,bfs[0].limit()));
        System.out.println("------------");
        System.out.println(new String(bfs[1].array(),0,bfs[0].limit()));

        //聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("E:\\悟空\\悟空2.jpg", "rw");
        FileChannel channel1 = raf2.getChannel();
        channel1.write(bfs);
    }

    //字符集
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
        //获取编码器和解码器
        CharsetEncoder encoder = gbk.newEncoder();
        CharsetDecoder decoder = gbk.newDecoder();
        CharBuffer cBuf = CharBuffer.allocate(1024);
        cBuf.put("牛犇");
        cBuf.flip();
        ByteBuffer buf1 = encoder.encode(cBuf);//编码
        //解码
        buf1.flip();
        CharBuffer buf2 = decoder.decode(buf1);
        System.out.println(buf2.length());
    }

}
