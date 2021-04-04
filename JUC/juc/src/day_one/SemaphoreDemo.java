package day_one;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);//模拟三个车位
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire(); //代表抢占了资源 -1
                    System.out.println(Thread.currentThread().getName()+"\t占用了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();  //还回资源。
                    System.out.println(Thread.currentThread().getName()+"\t离开了车位");
                }
            },String.valueOf(i)).start();
        }
    }
}
