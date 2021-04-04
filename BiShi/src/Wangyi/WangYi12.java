package Wangyi;

import java.text.DecimalFormat;
import java.util.Scanner;

public class WangYi12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] a = new int[n - 1];
        for (int i = 0; i < n-1 ; i++) {
            a[i] = sc.nextInt();
        }
    }
}