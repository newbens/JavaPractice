package NIO;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class TestPipe {
    @Test
    public void test1() throws IOException {
        //1.管道
        Pipe pipe = Pipe.open();
        //2.将缓冲区中的数据写入管道
        Pipe.SinkChannel sinkChannel = pipe.sink();
        ByteBuffer bf = ByteBuffer.allocate(1024);
        bf.put("通过单项管道发送数据".getBytes());
        bf.flip();
        sinkChannel.write(bf);
        //读取缓冲区中数据
        Pipe.SourceChannel sourceChannel = pipe.source();
        bf.flip();
        int len = sourceChannel.read(bf);
        System.out.println(new String(bf.array(),0,len));
        sourceChannel.close();
        sinkChannel.close();
    }
}
