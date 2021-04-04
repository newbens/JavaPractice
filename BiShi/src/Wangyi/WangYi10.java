package Wangyi;

import java.util.Scanner;

public class WangYi10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = new StringBuilder(String.valueOf(n)).reverse().toString();
        System.out.println(Integer.valueOf(s)+n);
    }
}
