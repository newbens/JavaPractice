package day_one;

import java.util.concurrent.*;

/**
 *    线程池
 *    7大参数：
 *      1.corePoolSize：线程池的核心线程数
 *      2.maximumPoolSize：最大线程数
 *      3.keepAliveTime：存活时间，当存活时间到了，线程池就会缩容
 *      4.TimeUnit unit： 存活时间的单位
 *      5.BlockingQueue<Runnable> workQueue：任务队列，提交但未执行的任务
 *      6.ThreadFactory threadFactory：生成线程的线程工厂
 *      7.RejectedExecutionHandler handler：拒绝策略，当队列满了，并且工作线程大于等于线程池的最大线程数，拒绝请求的runnable的策略。
 *          4种拒绝策略：
 *              1.AbortPolicy():直接抛出RejectedExecutionException异常阻止系统正常运行
 *              2.CallerRunsPolicy():回调机制，哪个线程让你来找我，我现在很忙，你回去找他
 *              3.DiscardOldestPolicy():放弃最老的机制，如果我处理不了你，就放弃你
 *              4.DiscardPolicy():放弃自己不能处理的任务=-------最好的策略
 */
public class MyThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(
                2,
                Runtime.getRuntime().availableProcessors(),//获取本机核数
                2L,//存活时间
                TimeUnit.SECONDS,//存活时间单位
                new LinkedBlockingDeque<>(3),//阻塞队列大小
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());//拒绝策略
            try {
                for (int i = 1; i < 20 ; i++) {
                    executor.execute(() -> {
                        System.out.println(Thread.currentThread().getName()+"\t办理业务");
                    });
            }}catch (Exception e){
                e.printStackTrace();
                }finally {
                executor.shutdown();
                }
        }




//        ExecutorService executorService = new ThreadPoolExecutor(
//                2,
//                //CPU密集型：CPU的核数是多少，最大线程数设为多少。
//                //IO密集型：判断程序中是否耗IO的线程的数量，最大线程数就设置为这个的2倍。
//                Runtime.getRuntime().availableProcessors() + 1,
//                2L,
//                TimeUnit.SECONDS,
//                new LinkedBlockingDeque<>(3),
//                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.DiscardPolicy());
//        try {
//            //模拟十个顾客来办理业务，线程池有5个业务员
//            for (int i = 1; i <= 20; i++) {
//                executorService.execute(() -> {
//                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
//                });
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            executorService.shutdown(); //归还线程
//        }


    private static void initPool() {
        //这三个API底层都是同一个类  ThreadPoolExecutor
        ExecutorService ex = Executors.newFixedThreadPool(5);//一池五个固定受理线程
        ExecutorService ex2 = Executors.newSingleThreadExecutor();//一池一个固定受理线程
        ExecutorService ex3 = Executors.newCachedThreadPool();//一池n线程，可扩容
        try {
            //模拟十个顾客来办理业务，线程池有5个业务员
            for (int i = 1; i <= 10 ; i++) {
                ex3.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ex3.shutdown(); //归还线程
        }
    }
}
