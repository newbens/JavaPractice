package cn.leetcode;

import org.junit.Test;

import java.util.Random;

//���������
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
     * ˼·��
     * ��̬�滮����ǰdp����洢���ǵ�ǰ���������߳�����ǰ���߳���������ߣ��ϱߣ�����dp�Աȣ�ȡ����С�ģ�����
     * һ����Ϊ��ǰ���߳���ͬ����ľͰԭ��
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
