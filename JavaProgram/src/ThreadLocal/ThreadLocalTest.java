package ThreadLocal;

import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> tl = new ThreadLocal<>();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tl.get());
        },"").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set("Å£ Ä");
        },"").start();

    }
}
