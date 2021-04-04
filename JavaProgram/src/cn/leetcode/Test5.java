package cn.leetcode;
//最长子字符串
public class Test5 {
    int maxLen = 1;
    int begin = 0;
    public static void main(String[] args) {
        String s = "babad";
        String solve = new Test5().solve(s);
        System.out.println(solve);

    }

    public String solve(String s){
        for (int i = 0; i < s.length() ;i++) {
            for (int j = i+1; j < s.length() ; j++) {
                if (j - i + 1 > maxLen && isHuiWen(s, i, j)) {
                  begin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin+maxLen);

    }

    public Boolean isHuiWen(String s,int left,int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    //-----------------------------------------方法二----------------------------------------
    //----------------------------------------动态规划----------------------------------------
    public String slove2(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length() ; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < s.length() ; j++) {
            for (int i = 0; j < s.length() ; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                }else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j - 1];
                    }
                }
                if(dp[i][j] && j-i+1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
                }
            }
        return s.substring(begin, begin + maxLen);
        }
    }

