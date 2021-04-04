package Wangyi;

import java.util.Scanner;

public class WangYi04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n ; i++) {
            a[i] = sc.nextInt();
            int num = sc.nextInt();
            slove(a, num);
        }
    }

    private static void slove(int[] a, int num) {
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            if ((num | a[i]) == num) {
                res |= a[i];
            }
        }
        if (res == num) {
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
