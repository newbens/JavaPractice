import java.util.concurrent.TimeUnit;

class MyThread{
    volatile int n = 10;

    public void add() {
        this.n = 11;
    }
}

/**
 * JMM :Java内存模型   可见性，原子性，一致性。  volatile只能保证可见性
 */
public class JMM {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        //线程A
        new Thread(() -> {
            try {
                System.out.println("A线程进来了");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myThread.add();
            System.out.println(Thread.currentThread().getName()+"\t线程A更新n,n="+myThread.n);
        },"A").start();


        while (myThread.n == 10) {
            //需要有一种通知机制 告知main线程，n一直被修改
        }
        System.out.println(Thread.currentThread().getName()+"\tover");

    }
}
