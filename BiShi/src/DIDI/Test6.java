package DIDI;


import java.util.*;


public class Test6 {

    static Integer[] a;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        a = new Integer[m];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }
        reslove2(m,n,a);
    }


    public static void reslove2(int m,int n,Integer[] a) {   //dp解法不超时
        long[][] dp = new long[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(a[i-1] <= j){
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - a[i - 1]];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
