package SouGou;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            for (int j = a; j <= b ; j++) {
                if (j < n) {
                    arr[j] = i + 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += i * arr[i];
        }
        System.out.println(res%100000009);
    }
}
