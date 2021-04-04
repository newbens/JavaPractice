package cn.leetcode.offer;

public class Test47 {
    public static void main(String[] args) {
        int[][] a = {{1,3,1}, {1,5,1}, {4,2,1}};
        int slove = slove(a);
        System.out.println(slove);
    }

    public static int slove(int[][] a) {
         int c = a.length;
        int r = a[0].length;
        int[][] dp = new int[c + 1][r + 1];
        for (int i = 1; i <= c ; i++) {
            for (int j = 1; j <= r ; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + a [i - 1][j - 1];
            }
        }
        return dp[c][r];
    }

}
