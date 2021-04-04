package day_one;

import java.io.OutputStreamWriter;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 *   现在两个线程。可以操作一个初始值为0的一个变量
 *     实现一个线程对该变量+1，一个-1.
 *     实现交替10轮，变量初始值为0.
 *  判断   干活  通知
 *  对线程交互中需要防止 多线程的虚假唤醒， 判断只用while不能用if
 */

class Airs{

    private int n = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void add() {
        lock.lock();
        try {
            while (n != 0) {
                condition.await();
            }
            n++;
            System.out.println(Thread.currentThread().getName()+"\t"+n);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void sub() {
        lock.lock();
        try {
            while (n == 0) {
                condition.await();
            }
            n--;
            System.out.println(Thread.currentThread().getName()+"\t"+n);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}

public class ThreadWaitNotify_lock {
    public static void main(String[] args) {
        Airs air = new Airs();

        new Thread(() -> {
            for (int i = 0; i < 10 ; i++) {
                air.add();
            }
            },"A").start();

        new Thread(() -> {
            for (int i = 0; i < 10 ; i++) {
                air.sub();
            }
            },"B").start();


    }
}
