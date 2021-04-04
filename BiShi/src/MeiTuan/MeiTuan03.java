package MeiTuan;

import java.util.Scanner;

public class MeiTuan03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
//        int m=scanner.nextInt();
//        ArrayList<Integer> list = new ArrayList<>();
        int dp[][]=new int[n+1][n+1];
        int sum[]=new int[n+1];
        for (int i = 1; i < n+1; i++) {
            int a=scanner.nextInt();
            sum[i]=sum[i-1]+a;
        }
//        System.out.println(Arrays.toString(sum));
        for (int len = 2; len <=n ; len++) {//一堆有多少组成
            //比如len=2  就是组合二堆为1堆
            //len=3 就是组合三堆为1堆
            for (int i = 1; i <=n-len+1 ; i++) {//起点
                int j=i+len-1;//终点
                dp[i][j]=Integer.MAX_VALUE;//为了一开始得到最小值
                int leastSum=sum[j]-sum[i-1];
                for (int k=i;k<j;k++) {
                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+leastSum);
                }
            }
        }
        System.out.println(dp[1][n]);
    }


}
