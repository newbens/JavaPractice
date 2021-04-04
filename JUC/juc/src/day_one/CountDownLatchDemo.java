package day_one;

import java.util.concurrent.CountDownLatch;

/**
 *              CountDownLatch主要有两个方法，当一个或多个线程调用await方法时，这些线程会被堵塞
 *              其他线程调用countDown方法会将计数器减一
 *              当计数器的值变为零时，await的方法会被唤醒
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6 ; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t离开教室");
                countDownLatch.countDown();//每执行一个线程 CountDownLatch的值就减一
            },String.valueOf(i)).start();
        }
        countDownLatch.await();  //最后执行的线程
        new Thread(() -> {
            System.out.println("锁门离开教室！");
            },"班长").start();
    }

}
