package day_one;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

//自旋锁
public class SpinLock {
    private AtomicReference<Thread> cas = new AtomicReference<>();

    public void lock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"加锁");
        while (!cas.compareAndSet(null, thread)) {
            System.out.println("...");
        }
    }

    public void unlock() {
        Thread thread = Thread.currentThread();
        cas.compareAndSet(thread, null);
        System.out.println(thread.getName()+"解锁");
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLock spinLock = new SpinLock();
        new Thread(() -> {
            spinLock.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock.unlock();
        },"A").start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            spinLock.lock();
            spinLock.unlock();
            },"B").start();

    }
}
