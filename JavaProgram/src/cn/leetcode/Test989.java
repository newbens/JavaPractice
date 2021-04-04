package cn.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//数组形式整数相加
public class Test989 {
    public static void main(String[] args) {
        int[] a = {1, 2, 0, 0};
        int b = 34;
        List slove = slove(a, b);
        Collections.reverse(slove);
        System.out.println(slove);
    }

    public static List slove(int[] a, int b) {
        List res = new ArrayList();
        for (int i = a.length-1; i >= 0; i--) {
            b += (a[i]);
            res.add(b % 10);
            b /= 10;
        }
        return res;
    }
}
