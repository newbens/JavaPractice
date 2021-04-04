package XiaoHongShu;

import java.util.Arrays;
import java.util.Scanner;

public class XiaoHongShu08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] dp = new int[n+1];
        int[] count = new int[n+1];
        count[1] = 1;
        dp[1] = a[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2]+a[i - 1], dp[i - 1]);
            if (dp[i] == dp[i - 1]) {
                count[i] = count[i - 1];
            }else {
                count[i] = count[i - 2] + 1;
            }
        }
        System.out.println(dp[n] +" "+count[n]);
    }
}
