package Wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class WangYi13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] a = new int[m];
            int count1 = 0;
            int count2 = 0;
            for (int j = 0; j < m; j++) {
                int num = sc.nextInt();
                if(num % 4 == 0) count1++;
                else if(num % 2 == 0) {
                    count2++;
                }
            }
            int odd = m - count1 - count2;
            if(count2 == 0){
                if(count1 >= odd-1) System.out.println("Yes");
                else System.out.println("No");
            }else{
                if(count1 >= odd) System.out.println("Yes");
                else System.out.println("No");
            }

        }
    }
}