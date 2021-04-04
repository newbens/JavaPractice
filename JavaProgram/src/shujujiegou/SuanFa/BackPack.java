package shujujiegou.SuanFa;

import java.util.Arrays;

//0-1背包问题
public class BackPack {
    public static void main(String[] args) {
        int[] weight = {2,3,5};
        int[] value = {3,4,6};
        int capacity = 10;
        int res = backPack(weight, value, capacity);
        System.out.println(res);
        int res2 = backPack2(weight, value, capacity);
        System.out.println(res2);
    }

    public static int backPack(int[] w,int[] v,int c) {
        int[][] bp = new int[w.length+1][c+1];
        for (int i = 1; i < bp.length ; i++) {
            for (int j = 1; j < bp[0].length ; j++) {
                if(w[i-1] > j){
                    bp[i][j] = bp[i - 1][j];
                }else{
                    bp[i][j] = Math.max(bp[i - 1][j], v[i-1] + bp[i - 1][j - w[i-1]]);
                }
            }
        }
        System.out.println(Arrays.deepToString(bp));
        return bp[w.length][c];
    }

    public static int backPack2(int[] w,int[] v,int c) {    //优化
        int[] dp = new int[c+1];
        for (int i = 0; i <w.length ; i++) {
            for (int j = dp.length-1; j >= w[i] ; j--) {
                dp[j] = Math.max(dp[j],v[i]+dp[j-w[i]]);
            }

        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length-1];
    }
}
