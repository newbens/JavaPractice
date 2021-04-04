package cn.leetcode;

public class Test56_1 {
    public static void main(String[] args) {
        int[] nums = {4, 4, 2, 6};
        int res = 0;
        for (int i = 0; i <nums.length ; i++) {
            res ^= nums[i];
        }
        System.out.println(res);
        int x = 0;
        int y = 0;
        int k = 1;
        while ((k & res) == 0) {
            k <<= 1;
        }
        for (int i = 0; i <nums.length ; i++) {
            if ((k & nums[i]) == 0) {
                x ^= nums[i];
            }else {
                y ^= nums[i];
            }
        }
        System.out.println(x+" "+y);
    }
    }

