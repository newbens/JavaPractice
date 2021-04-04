package Wangyi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WangYi07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[num];
            for (int j = 0; j < num; j++) {
                a[j] = sc.nextInt();
            }
            boolean reslove = solution(a, k);
            if(reslove) System.out.println("YES");
            else System.out.println("NO");
        }

    }

    public static boolean solution(int[] nums, int k){
        int n = nums.length;
        boolean[][] dp = new boolean[n][2];
        dp[0][0] = true;
        dp[0][1] = true;
        for (int i = 1; i < n; i++){
            for (int j = 1; j <= k && i - j >= 0; j++){
                if (nums[i-j] >= nums[i]){
                    dp[i][0] |= dp[i-j][0];
                    dp[i][1] |= dp[i-j][1];
                }
                dp[i][1] |= dp[i-j][0];
            }
        }
        return dp[n-1][0] || dp[n-1][1];
    }
}
