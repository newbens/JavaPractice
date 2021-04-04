package cn.leetcode;

import org.junit.Test;

//°Ú¶¯ÐòÁÐ
public class Test376 {
    @Test
    public void slove() {
        int[] a = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        int[] up = new int[a.length];
        int[] down = new int[a.length];
        up[0] = down[0] = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[i - 1]) {
                up[i] = down[i-1]+1;
                down[i] = down[i - 1];
            } else if (a[i] < a[i - 1]) {
                up[i] = up[i - 1];
                down[i] = up[i - 1] + 1;
            }else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        System.out.println(Math.max(up[a.length - 1], down[a.length - 1]));
    }
}
