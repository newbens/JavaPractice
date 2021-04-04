package XiaoHongShu;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;


public class XiaoHongShu02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        solve(a);
    }

    public static void solve(int[] a) {
        int n = a.length;
        int[] dp = new int[n+1];
        int[] count = new int[n + 1];
        dp[1] = a[0];
        count[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+a[i-1]);
            if (dp[i] == dp[i - 1]) {
                count[i] = count[i - 1];
            }else{
                count[i] = count[i-2]+1;
            }
        }
        System.out.println(dp[n]);
        System.out.println(count[n]);
    }
}
