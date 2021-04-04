package cn.leetcode;

import org.junit.Test;

import java.util.Random;

//最大正方形
public class Test221 {
    public static void main(String[] args) {
        int[][] a = {{1, 0, 1, 0, 0},
                     {1, 0, 1, 1, 1},
                     {1, 1, 1, 1, 1},
                     {1, 0, 0, 1, 0}};
        int res = solve(a);
        System.out.println(res);
    }

    /**
     * 思路：
     * 动态规划，当前dp数组存储的是当前正方形最大边长，当前最大边长可以与左边，上边，左上dp对比，取出最小的，加上
     * 一，就为当前最大边长，同理与木桶原则。
     *
     * @param a
     * @return
     */

    public static int solve(int[][] a) {
        int width = a[0].length;
        int high = a.length;
        int maxSide = 0;
        int[][] dp = new int[high + 1][width + 1];
        for (int i = 0; i < high; i++) {
            for (int j = 0; j < width; j++) {
                if (a[i][j] == 1) {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i+1][j]), dp[i][j]) + 1;
                    maxSide = Math.max(maxSide, dp[i+1][j+1]);
                }
            }
        }
        return maxSide * maxSide;
    }

    @Test
    public void test() {
        int i = new Random().nextInt(1000);
        int res = (int) Math.sqrt(i);
        System.out.println(i+"  "+res);

    }
}
