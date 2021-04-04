package XiaoHongShu;

import java.util.Arrays;
import java.util.Scanner;

public class XiaoHongShu05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        String[] ss = s.substring(1, s.length() - 1).split(",");
        int[] a = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            a[i] = Integer.valueOf(ss[i]);
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i : a) {
            for (int j = i; j <= n; j++) {
                dp[j] = dp[j] + dp[j - i];
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
