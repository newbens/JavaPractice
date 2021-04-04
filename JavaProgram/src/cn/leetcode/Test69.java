package cn.leetcode;

import java.util.Random;

/**
 * 求平方根
 */
public class Test69 {
    public static void main(String[] args) {
        long x = new Random().nextInt(1000000000);
        long left = 0;
        long right = x / 2 + 1;
        while (left < right) {
            long mid = left + (right - left + 1) / 2;
            if ((mid * mid) > x) {
                right = mid -1;
            }else {
                left = mid;
            }
        }
        System.out.println(left);
        int res = (int) Math.sqrt(x);
        System.out.println(res);
    }
}

