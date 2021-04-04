package QIAnXin;
//背包问题

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Year;
import java.util.Scanner;

public class QIAnXin01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        int n = scanner.nextInt();
        int[] p = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
        }
        new QIAnXin01().beibao01(n, money, p, v);
        new QIAnXin01().wanquanbeibao(n, money, p, v);

    }

    public void beibao01(int n, int money, int[] p, int[] v) { //01背包
        int[] dp = new int[money + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = money; j >= p[i-1]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - p[i - 1]] + v[i - 1]);
            }
        }
        System.out.println(dp[money]);
    }

    public void wanquanbeibao(int n, int money, int[] p, int[] v) {
        int[] dp = new int[money+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= money; j++) {
                    if (j >= p[i - 1]) {
                        dp[j] = Math.max(dp[j], dp[j -  p[i - 1]] +  v[i - 1]);

                }
            }
        }
        System.out.println(dp[money]);
    }
}
