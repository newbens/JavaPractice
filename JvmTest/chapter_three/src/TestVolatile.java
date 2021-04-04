import java.util.concurrent.TimeUnit;

class Num{
    int n = 0;

    public void add() {
        n += 10;
    }

    public synchronized void addPlus() {
        n ++;
    }
}

public class TestVolatile {
    public static void main(String[] args) throws InterruptedException {
    atomic();
    }
    //验证可见性
    private static void seeVolatile() {
        Num num = new Num();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"\t  进入");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            num.add();
            System.out.println(Thread.currentThread().getName()+"\t  结束 n="+num.n);
        },"A").start();

        while (num.n == 0) {
        }
        System.out.println(Thread.currentThread().getName());
    }

    //验证原子性  不保证
    public static void atomic() throws InterruptedException {
        Num num = new Num();
        for (int i = 1; i <= 20 ; i++) {
            new Thread(() -> {
                for (int j = 0; j <1000 ; j++) {
                    num.addPlus();
                }
            },String.valueOf(i)).start();
        }
        //默认有两个线程
        while (Thread.activeCount() > 2) {
            Thread.yield();   //礼让线程
        }
        System.out.println(Thread.currentThread().getName()+"\t n="+num.n);

    }
}
