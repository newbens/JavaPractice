package day_one;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *    多线程之前实现调用实现A->B->C
 *  A打印五次，B打印十次，C打印十五次
 *
 *    标志位
 *
 */
class Resource{



    private  int n=1; //1:A 2:b 3:c
    private Lock lock = new ReentrantLock();
    //一把锁三把钥匙
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            //判断
            while (n != 1) {
                condition1.await();
            }
            //干活
            for (int i = 0; i < 5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            n = 2;//修改标志位
            condition2.signal();//精确唤醒
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            //判断
            while (n != 2) {
                condition2.await();
            }
            //干活
            for (int i = 0; i < 10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            n = 3;//修改标志位
            condition3.signal();//精确唤醒
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            //判断
            while (n != 3) {
                condition3.await();
            }
            //干活
            for (int i = 0; i < 15 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            //通知
            n = 1;//修改标志位
            condition1.signal();//精确唤醒
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class ThreadOrderAccess {
    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(() -> {
            for (int i = 0; i < 10 ; i++) {
                resource.print5();
            }
            },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 10 ; i++) {
                resource.print10();
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 0; i < 10 ; i++) {
                resource.print15();
            }
        },"C").start();

    }
}
