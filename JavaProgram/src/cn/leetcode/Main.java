package cn.leetcode;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.0000");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double res = slove(0, n);
        System.out.println(res);
        String format = df.format(res);
        System.out.println(Math.floor(Double.parseDouble(format)));
    }

    public static double slove(int m,int n) {
        double res = 0;
        if(m > n) return 0;
        res += 1 / (5 * Math.pow(2, m))+Math.pow(-1,m+1%2)*slove(m+1,n);
        return res;
    }


}
