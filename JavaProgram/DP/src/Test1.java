import java.util.Arrays;
import java.util.Scanner;

//区间dp   石子合并问题1
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        new Test1().getRes(n,a);
    }

    public void getRes(int n,int[] a) {
        int[][] dp = new int[n+1][n+1];
        int[] sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i] += a[i-1] + sum[i - 1];
        }
        System.out.println(Arrays.toString(sum));
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len +1; i++) {
                int j = i + len - 1; //终点
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j ; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[j] - sum[i - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
    }

}
