package XiaoHongShu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class XiaoHongShu04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
        }
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        int[]dp = new int[n];
        Arrays.fill(dp,1);
        int[] b = new int[n];
        int res = 0;
        for (int i = 0; i < n ; i++) {
            b[i] = a[i][1];
        }
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < i ; j++) {
                if (b[j] < b[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }
}
