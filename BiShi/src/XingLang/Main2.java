package XingLang;

import javafx.scene.input.PickResult;

public class Main2 {
    public static void main(String[] args){

    }

    public String longestPalindrome(String s) {
//        int len = s.length();
//        if(len < 2) return s;
        int l = 1;
        int start = 0;
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (chars[j] != chars[i]) {
                    dp[j][i] = false;
                }else {
                    if (i - j < 3) {
                        dp[j][i] = true;
                    }else {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                }
                if (dp[j][i] && i - j + 1 > l) {
                    l = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, start + l);
    }
}
