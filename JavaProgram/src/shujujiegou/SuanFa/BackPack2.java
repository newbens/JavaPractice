package shujujiegou.SuanFa;

import java.util.Arrays;

//             ÍêÈ«±³°ü
public class BackPack2 {
    public static void main(String[] args) {
        int[] value = {1, 2, 5, 10};
        int num = 3;
        int res = backPack(value, num);
        System.out.println(res);

    }

    public static int backPack(int[] value, int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp.length + 1;
        }
        System.out.println(Arrays.toString(dp));
        for (int i = 0; i < value.length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (j >= value[i]) {
                    dp[j] = Math.min(dp[j],1+dp[j-value[i]]);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }
}
