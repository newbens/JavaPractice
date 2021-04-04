package NIO;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class TestPipe {
    @Test
    public void test1() throws IOException {
        //1.�ܵ�
        Pipe pipe = Pipe.open();
        //2.���������е�����д��ܵ�
        Pipe.SinkChannel sinkChannel = pipe.sink();
        ByteBuffer bf = ByteBuffer.allocate(1024);
        bf.put("ͨ������ܵ���������".getBytes());
        bf.flip();
        sinkChannel.write(bf);
        //��ȡ������������
        Pipe.SourceChannel sourceChannel = pipe.source();
        bf.flip();
        int len = sourceChannel.read(bf);
        System.out.println(new String(bf.array(),0,len));
        sourceChannel.close();
        sinkChannel.close();
    }
}
