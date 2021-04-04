package cn.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 丑数  包含因子2，3，5，
 */
public class Test49 {
    public static void main(String[] args) {
        int slove = slove(10);
        System.out.println(slove);

    }

    public static int slove(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int a = 0;
        int b = 0;
        int c = 0;
        while (n >= 0) {
            int x = list.get(a) * 2;
            int y = list.get(b) * 3;
            int z = list.get(c) * 5;
            int min = Math.min(x, Math.min(y, z));
            list.add(min);
            if (min == x) {
                a ++;
            } else if (min == y) {
                b ++;
            }else {
                c ++;
            }
            n--;
        }
        return list.get(list.size() - 1);
    }

    public static int slove2(int n) {
                int a = 0, b = 0, c = 0;
                int[] dp = new int[n];
                dp[0] = 1;
                for(int i = 1; i < n; i++) {
                    int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
                    dp[i] = Math.min(Math.min(n2, n3), n5);
                    if(dp[i] == n2) a++;
                    if(dp[i] == n3) b++;
                    if(dp[i] == n5) c++;
                }
                return dp[n - 1];
        }
    }

