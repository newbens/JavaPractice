package cn.leetcode.offer;

import java.util.Arrays;

public class Test29 {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int b = a.length - 1;
        int r = a[0].length - 1;
        int index = 0, t = 0, l = 0;
        int[] res = new int[(b + 1) * (r + 1)];
        while (true) {
            for (int i = l; i <= r; i++) {    //左到右
                res[index++] = a[t][i];
            }
            if (++t > b) {   //这层遍历后  顶层便减一。
                break;
            }
            for (int i = t; i <= b; i++) {    //上到下
                res[index++] = a[i][r];
            }
            if (--r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {   //右到左
                res[index++] = a[b][i];
            }
            if (--b < t) {
                break;
            }
            for (int i = b; i >= t; i--) {  //下到上
                res[index++] = a[i][l];
            }
            if (++l > r) {
                break;
            }
        }
        System.out.println(Arrays.toString(res));
    }
}

