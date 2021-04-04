package GrowingIO;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int x = a.length();
        int y = b.length();
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[x][y]);
    }
}
