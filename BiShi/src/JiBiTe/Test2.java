package JiBiTe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[m+1][n+1];
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                dp[i][j] = Math.min(Math.max(1, dp[i+1][j]), Math.max(1, dp[i][j+1])) - a[i][j];
            }
        }
        dp[0][0] = dp[0][0] > 0 ? dp[0][0] : 1;
        System.out.println(Arrays.deepToString(dp));
    }
}