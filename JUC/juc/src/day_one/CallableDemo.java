package day_one;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 *    callable和runnable的区别
 *      callable会有异常，有返回值，实现call方法
 *      runnable无异常，无返回值，实现run方法
 *
 *     callable:
 *      get方法一般放在最后一排
 *
 */
class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("*********************");
        return 1224;
    }
}


public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask futureTask = new FutureTask(new MyThread());
        new Thread(futureTask,"A").start();  //虽然两个线程但是是同一个对象，所以只会打印一次。
        new Thread(futureTask,"B").start();
        System.out.println(Thread.currentThread().getName()+"******计算完成");
        System.out.println(futureTask.get());//get方法一般在最后调用，否则可能会导致线程堵塞。
}
}
