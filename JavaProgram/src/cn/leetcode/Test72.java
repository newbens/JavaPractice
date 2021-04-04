package cn.leetcode;

import java.util.Arrays;
// 编辑距离
public class Test72 {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        int[][] s = getMinStep(word1, word2);
        System.out.println(Arrays.deepToString(s));

    }

    public static int[][] getMinStep(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] s = new int[n + 1][m + 1];
        for (int i = 0; i <=n ; i++) {
            s[i][0] = i;
        }
        for (int i = 0; i <=m ; i++) {
            s[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    s[i][j] = s[i - 1][j - 1];
                } else {
                    s[i][j] = Math.min(Math.min(s[i - 1][j - 1], s[i][j - 1]), s[i - 1][j])+1;
                }
            }
        }
        return s;
    }
}
