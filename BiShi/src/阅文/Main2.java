package 阅文;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        System.out.println(check(n));
    }

    public static boolean check(long n) {
        for (int i = 2; i < n/2+1; i++) {
            if ((n % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
