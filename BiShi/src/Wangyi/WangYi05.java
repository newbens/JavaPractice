package Wangyi;

import java.util.Scanner;

public class WangYi05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n ; i++) {
            long a = sc.nextInt();
            long b = sc.nextInt();
            long p = sc.nextInt();
            long q = sc.nextInt();
            int step = 0;
            while (a < b) {
                if(a + p >= b) a = a + p;
                else {
                    p = p * q;
                }
                step ++;
            }
            System.out.println(step);
        }
    }
}
