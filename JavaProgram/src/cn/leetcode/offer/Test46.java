package cn.leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//°ÑÊý×Ö·­Òë³É×Ö·û´®
public class Test46 {
    public static void main(String[] args) {
        int a = 12258;
        int slove = slove(a);
        System.out.println(slove);
    }

    public static int slove(int a) {
        List<Integer> help = new ArrayList<>();
        while (a > 0) {
            int i = a % 10;
            a /= 10;
            help.add(i);
        }
        Collections.reverse(help);
        int[] dp = new int[help.size() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= help.size() ; i++) {
            if(help.get(i-2) == 1|| help.get(i-2) == 2 && help.get(i-1) < 6  ) dp[i] = dp[i - 1] + dp[i - 2];
            else dp[i] = dp[i - 1];
        }
        System.out.println(Arrays.toString(dp));
        return dp[help.size()];
    }
}
