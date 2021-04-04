package Wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class WangYi03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //数组大小
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n ; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        while (m > 0) {
            m--;
            int num = sc.nextInt();
            int count = 0;
            if(num > a[n-1]) {
                System.out.println(0);
                continue;
            }
            for (int i = n-1; i >= 0 ; i--) {
                if(a[i] < num) break;
                else {
                    count ++;
                    a[i] --;
                }
            }
            System.out.println(count);
        }

    }
}
