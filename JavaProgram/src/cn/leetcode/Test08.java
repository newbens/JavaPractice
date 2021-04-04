package cn.leetcode;

public class Test08 {
    public static void main(String[] args) {
        int n = 10;
        int[] c = {1, 5, 10, 25};
        int res = dp(n, c);
        System.out.println(res);
    }

    public static int dp(int n,int[] c) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length ; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < 4 ; i++) {
            if(c[i] > n) return dp[n];
            for (int j = c[i]; j < dp.length; j++) {
                dp[j] = dp[j] + dp[j - c[i]];
            }
        }
        return dp[n];
    }
}
