package 天融信;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.*;

public class Main1 {
    public static void main(String[] args) throws InterruptedException {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        factor(n);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            }).start();
        }





    }

    public static void factor(int num) {
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                System.out.println(i);
                num /= i;
                i--;
            }
        }
        System.out.println(num);
    }
}
