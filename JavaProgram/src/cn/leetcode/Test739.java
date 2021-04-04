package cn.leetcode;

import java.util.Arrays;

/**
 * Ã¿ÈÕÎÂ¶È
 */
public class Test739 {
    public static void main(String[] args) {
        int[] t = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] tem = tem(t);
        System.out.println(Arrays.toString(tem));
    }

    public static int[] tem(int[] t) {
        int[] dp = new int[t.length];
        dp[t.length - 1] = 0;
        for (int i = t.length - 2; i >= 0; i--) {
            if (t[i] < t[i + 1]) {
                dp[i] = 1;
            } else {
                int k = i + 1;
                while (k < t.length) {
                    if (t[k] == 0 && t[k] < t[i]) {
                        dp[i] = 0;
                        break;
                    }
                    if (t[k] > t[i]) {
                        dp[i]++;
                        break;
                    }
                    dp[i]++;
                    k++;
                }
            }
        }
        return dp;
    }
}
