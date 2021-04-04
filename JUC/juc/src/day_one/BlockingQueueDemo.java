package day_one;

import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *   阻塞队列
 *   三组：
 *    第一组：抛出异常组： add   remove  element   如果超出队列大小就会抛出异常
 *    第二组：不抛出异常   offer poll    peek      如果超出队列大小返回null（offer方法可以设置超时时间，如果超过时间还未放进去就返回false）
 *    第三组：等待型       put  take
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(3);


        //抛出异常组---------------------------------------------------------------------------------------------------
        System.out.println(bq.add("A"));
        System.out.println(bq.add("B"));
        System.out.println(bq.add("C"));
        System.out.println(bq.remove());
        bq.element();//检查是否有元素


        //插入超出队列大小返回flase，poll超出队列范围 返回null-----------------------------------------------------------------
        System.out.println(bq.offer("A"));
        System.out.println(bq.offer("B"));
        System.out.println(bq.offer("C"));
        System.out.println(bq.offer("D"));
        System.out.println(bq.poll());
        System.out.println(bq.poll());
        System.out.println(bq.poll());
        System.out.println(bq.poll());
        System.out.println(bq.poll());
        bq.peek();//检查是否有元素


        //用put方法如果队列以满，将会一直堵塞直到队列有位置，再put进去-----------------------------------------------------------
        bq.put("A");
        bq.put("B");
        bq.put("C");
        bq.put("D");
        System.out.println(bq.take());
        System.out.println(bq.take());
        System.out.println(bq.take());
        System.out.println(bq.take());


        //offer 可以设置超时时间，如果超时还未添加进去，就报false--------------------------------------------------------------
        System.out.println(bq.offer("A"));
        System.out.println(bq.offer("B"));
        System.out.println(bq.offer("C"));
        System.out.println(bq.offer("C",3,TimeUnit.SECONDS));
        bq.poll();

    }
}
