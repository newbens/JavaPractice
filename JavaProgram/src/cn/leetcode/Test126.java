package cn.leetcode;

import java.util.Arrays;

//µ¥´Ê½ÓÁú
public class Test126 {
    public static void main(String[] args) {
        int[] a = {8,8,11,12,10};
        Arrays.sort(a);
        int zero = 0;
        int cha = 0;
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < a.length -1 ; i++) {
            if (a[i] == 0) {
                zero++;
            }else if (a[i] + 1 != a[i + 1]) {
                cha += (a[i + 1] - a[i] - 1);
            }
        }
        System.out.println(cha);
        System.out.println(zero);
    }

}
