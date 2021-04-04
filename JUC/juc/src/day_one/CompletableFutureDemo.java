package day_one;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 *--------------------------------------异步回调--------------------------------------------------------
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "无返回值");
        });


        //异步回调
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "有返回值");
            int i = 10 / 0;
            return 1024;
        });
        integerCompletableFuture.whenComplete((t,u) -> {
            System.out.println("**********"+t);
            System.out.println("**********"+u);
        }).exceptionally( f -> {
            System.out.println("************"+f.getMessage());
            return 4444;
        });
    }
}
