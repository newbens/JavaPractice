package GoWhere;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] s1 = new String[num];
        String[] s2 = new String[num];
        for (int i = 0; i < num; i++) {
            s1[i] = sc.next();
        }
        for (int i = 0; i < num; i++) {
            s2[i] = sc.next();
        }
        int[][] dp = new int[num+1][num+1];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (s1[i].equals(s2[j])) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        System.out.println(dp[num][num]);
    }
}
