package cn.leetcode.offer;

import java.util.Arrays;

public class Kp {
    public static void main(String[] args) {
        int[] a = {2, 6, 8, 1, 74, 9, 7};
        new Kp().kuaiSu(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    /**
     * ¿ìËÙÅÅÐò
     * @param a
     * @param lo
     * @param hi
     */
    public void kuaiSu(int[] a,int lo,int hi) {
        if (lo > hi) {
            return;
        }
        int i,j,t,temp;
        i = lo;
        j = hi;
        temp = a[lo];
        while (i < j) {
            while (i < j && a[j] >= temp) {
                j --;
            }
            while (i < j && a[i] <= temp) {
                i ++;
            }
            t = a[j];
            a[j] = a[i];
            a[i] = t;
        }
        a[lo] = a[i];
        a[i] = temp;
        kuaiSu(a, lo, i - 1);
        kuaiSu(a, i + 1, hi);
    }
}
