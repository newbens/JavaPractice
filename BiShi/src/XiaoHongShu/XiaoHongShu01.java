package XiaoHongShu;

import javax.swing.plaf.SliderUI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class XiaoHongShu01 {
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        String[] split = s.substring(1, s.length()-1).split(",");
        int[] a = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            a[i] = Integer.valueOf(split[i]);
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i : a) {
            for (int j = i; j <= n ; j++) {
                dp[j] = dp[j] + dp[j - i];
            }
        }
        System.out.println(dp[n]);
    }
}
