package NIO;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * һ������������Java NIO�������ݵĴ�ȡ���������������飬���ڴ洢��ͬ�������͵�����
 *
 *   �����������Ͳ�ͬ���ṩ�˶�Ӧ���͵Ļ�������boolean����
 * ������ȡ���ݷ���
 *      put()  get()
 * �����������ĸ�����
 *     capacity���������
 *     limit������ ���Բ������ݵĴ�С ��limit��������ݲ��ܽ��в�����
 *     position�����������ڲ�����λ��  position <= limit <= capacity
 *     mark����¼��ǰpositionλ�ã�����ͨ��reset�ָ���mark��λ��
 * �ģ�ֱ�ӻ������ͷ�ֱ�ӻ�����
 *     ��ֱ�ӻ�������������JVM���ڴ���
 *     ֱ�ӻ������������������ڴ���
 */
public class TestBuffer {
    @Test
    public void test1(){
        //1.����ָ����С������
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        //2.����
        String s = "abcdef";
        buffer.put(s.getBytes());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        //3.������
        buffer.flip();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        //4.get()
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println(new String(bytes,0,bytes.length));
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        //5.rewind()  :�ظ�������
        buffer.rewind();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        //6.��ջ�����   ���ǻ������е�������Ȼ���ڣ����ݴ��ڱ�����״̬
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
