package day_one;

import com.sun.corba.se.impl.resolver.FileResolverImpl;

/**
 *   现在两个线程。可以操作一个初始值为0的一个变量
 *     实现一个线程对该变量+1，一个-1.
 *     实现交替10轮，变量初始值为0.
 *  判断   干活  通知
 *  对线程交互中需要防止 多线程的虚假唤醒， 判断只用while不能用if
 */

class Air{

    private int n = 0;

    public synchronized void add() throws InterruptedException {
        //1.判断
        while (n != 0) {
         this.wait();
        }
        //2.干活
        n ++;
        System.out.println(Thread.currentThread().getName()+"\t"+n);
        //3.通知
        this.notifyAll();
    }

    public synchronized void sub() throws InterruptedException {
        //1.判断
        while (n == 0) {
            this.wait();
        }
        //2.干活
        n --;
        System.out.println(Thread.currentThread().getName()+"\t"+n);
        //3.通知
        this.notifyAll();
    }
}

public class ThreadWaitNotify {
    public static void main(String[] args) {
        Air air = new Air();
        new Thread(() -> {
            for (int i = 0; i < 10 ; i++) {
                try {
                    air.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10 ; i++) {
                try {
                    air.sub();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 10 ; i++) {
                try {
                    air.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 10 ; i++) {
                try {
                    air.sub();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();


    }
}
