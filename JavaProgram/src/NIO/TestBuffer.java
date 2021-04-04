package NIO;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * 一。缓冲区：在Java NIO负责数据的存取，缓存区就是数组，用于存储不同数据类型的数据
 *
 *   根据数据类型不同，提供了对应类型的缓冲区，boolean除外
 * 二。存取数据方法
 *      put()  get()
 * 三。缓冲区四个属性
 *     capacity：最大容量
 *     limit：界限 可以操作数据的大小 （limit后面的数据不能进行操作）
 *     position：缓冲区正在操作的位置  position <= limit <= capacity
 *     mark：记录当前position位置，可以通过reset恢复到mark的位置
 * 四：直接缓冲区和非直接缓冲区
 *     非直接缓冲区：建立在JVM的内存中
 *     直接缓冲区：建立在物理内存中
 */
public class TestBuffer {
    @Test
    public void test1(){
        //1.分配指定大小缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        //2.存入
        String s = "abcdef";
        buffer.put(s.getBytes());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        //3.读数据
        buffer.flip();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        //4.get()
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println(new String(bytes,0,bytes.length));
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        //5.rewind()  :重复读数据
        buffer.rewind();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        //6.清空缓冲区   但是缓冲区中的数据依然存在，数据处于被遗忘状态
        buffer.clear();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
    }

    @Test
    public void testMark() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        String s = "123";
        buffer.put(s.getBytes());
        buffer.flip();
        buffer.mark();
        byte[] bytes = new byte[2];
        buffer.get(bytes,0,2);
        System.out.println(buffer.position());
        buffer.reset();
        System.out.println(buffer.position());
    }

    @Test
    public void testDirectBuffer() {
        ByteBuffer d = ByteBuffer.allocateDirect(1024);
        System.out.println(d.isDirect());
    }
}
