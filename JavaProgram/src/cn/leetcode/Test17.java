package cn.leetcode;

import java.util.Arrays;

public class Test17 {
    //旋转数组
    public static void main(String[] args) {
        int[][] a = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        System.out.println(Arrays.deepToString(new Test17().solve(a)));
        int[][] b = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        System.out.println(Arrays.deepToString(new Test17().solve2(b)));
    }

    private int[][] solve(int[][] a) {
        int length = a.length;
        int[][] help = new int[length][length];   //辅助数组
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                help[j][length - i - 1] = a[i][j];  //将旋转后的值存入辅助数组
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                a[i][j] = help[i][j];           //把旋转后的值赋给原数组
            }
        }
        return a;
    }

    private int[][] solve2(int[][] a) {   //不需要辅助数组的方法
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len  ; j++) {
                int tem = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = tem;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len/2; j++) {
                int tem = a[i][j];
                a[i][j] = a[i][len - j - 1];
                a[i][len - j - 1] = tem;
            }
        }
        return a;
    }
}
