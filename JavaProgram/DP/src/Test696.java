import java.util.Arrays;
import java.util.Scanner;

public class Test696 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int count = getCount(s);
        System.out.println(count);
    }

    public static int getCount(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (c != s.charAt(i-1)) dp[i] = dp[i-1]+1;
            else {
                if(i - 1- dp[i-1] >= 0 && c != s.charAt(i - 1- dp[i-1])) dp[i] = dp[i-1] + 1;
                else dp[i] = 0;
            }
        }
        System.out.println(Arrays.toString(dp));
        int res = 0;
        for (int i = 0; i < n; i++) {
            if(dp[i] != 0) res++;
        }
        return res;
    }
}
