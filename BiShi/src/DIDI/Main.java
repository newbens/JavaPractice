package DIDI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//行数
        int m = sc.nextInt();//列数
        char[][] map = new char[n][m];
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;
        int z = 0;
        while (true) {
            //顶部输入
            for (int i = left; i <= right; i++) {
                map[top][i] = (char) (z++ % 26 + 65);
            }
            top++;
            if (top > bottom) break;
            //右部输入
            for (int i = top; i <= bottom; i++) {
                map[i][right] = (char) (z++ % 26 + 65);
            }
            right--;
            if (right < left) break;
            //底部输入
            for (int i = right; i >= left; i--) {
                map[bottom][i] = (char) (z++ % 26 + 65);
            }
            bottom--;
            if (top > bottom) break;
            //左部输入
            for (int i = bottom; i >= top; i--) {
                map[i][left] = (char) (z++ % 26 + 65);
            }
            left++;
            if (right < left) break;
        }
        for (int i = 0; i < n; i++) {
                System.out.println(map[i]);
        }
    }
}
