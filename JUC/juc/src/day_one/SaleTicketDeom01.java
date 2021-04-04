package day_one;

import javax.naming.Name;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个售票员 卖30张票
 * 1. 在高内聚低耦合下，线程操作资源类
 *  多线程的6种状态：new, runnable, blocked, waiting(不见不散), timed_waiting(), terminated
 *
 */
class Ticket{
    private int num = 3000;
    private int s = 1;

    Lock lock = new ReentrantLock();//可重入锁
    public void sale() {
        lock.lock();
        try {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName()+"\t卖出第："+(s++)+"\t还剩下："+--num);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}



public class SaleTicketDeom01 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 4000 ; i++) {
                    ticket.sale();
                }
            },"A").start();
        new Thread(() -> {
            for (int i = 0; i < 4000 ; i++) {
                ticket.sale();
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 0; i < 4000 ; i++) {
                ticket.sale();
            }
        },"C").start();

    }
}
