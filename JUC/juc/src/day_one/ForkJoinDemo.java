package day_one;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 分支合并框架
 * ForkJoinPool
 * ForkJoinTask
 * RecursiveTask
 */

class MyTask extends RecursiveTask<Integer> {

    public static final Integer VALUE = 10;
    private Integer start;
    private Integer end;
    private Integer res;

    public MyTask(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if ((end - start) <= VALUE) {
            for (int i = start; i <= end ; i++) {
                res = res + i;
            }
        }else {
            int mid = (end + start) / 2;
            MyTask myTask1 = new MyTask(start, mid);
            MyTask myTask2 = new MyTask(mid+1,end);
            myTask1.fork();
            myTask2.fork();//fork就会继续调用compute方法  递归
            res = myTask1.join() + myTask2.join();
        }
        return res;
    }
}


public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        MyTask myTask = new MyTask(0,100);
        ForkJoinPool threadPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = threadPool.submit(myTask);
        System.out.println(forkJoinTask.get());
        threadPool.shutdown();  //切记shutdown

    }
}
