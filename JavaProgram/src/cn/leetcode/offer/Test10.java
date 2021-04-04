package cn.leetcode.offer;

import java.util.Scanner;

//青蛙
public class Test10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入n:");
        int n = scanner.nextInt();
        int res = new Test10().get(n);
        System.out.println(res);
    }

    public int get(int n) {    //斐波拉契解法
        int[] res = new int[n + 2];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i] = (res[i - 1] + res[i - 2]) % 1000000007;
        }
        return res[n];
    }


}
