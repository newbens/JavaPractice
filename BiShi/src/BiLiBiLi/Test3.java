package BiLiBiLi;

import java.util.Arrays;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //数量
        int m = sc.nextInt(); //背包大小
        int[] g = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            g[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }
        int[][] dp = new int[n+1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j >= g[i-1]) dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j - g[i - 1]] + v[i - 1]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
    }
}
