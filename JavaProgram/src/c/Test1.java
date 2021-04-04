package c;

//奇安信笔试题一  完全背包

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();  //价格
            b[i] = sc.nextInt();  //效益
        }
        new Test1().beibao01(n,money,a,b);
    }

    public void beibao01(int n,int money,int[] a,int[] b) {   //01背包
        int[] dp = new int[money+1];
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= money ; j++) {
                if(j > a[i-1])
                    dp[j] = Math.max(dp[j], dp[j - a[i-1]] + b[i-1]);
                }

        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[money]);
    }

    public void beibao(int n,int money,int[] a,int[] b) {   //完全背包
        int[][] dp = new int[n+1][money+1];
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= money ; j++) {
                for (int k = 0; k * a[i-1] <= j; k++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - k * a[i - 1]] + k * b[i - 1]);
                }
            }
        }
        System.out.println(dp[n][money]);
    }

    @Test
    public void test() {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);

        String s3 = new String("abc");
        System.out.println(s1 == s3);
        Object o;
    }

}


