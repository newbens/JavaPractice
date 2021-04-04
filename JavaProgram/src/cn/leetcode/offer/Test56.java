package cn.leetcode.offer;

import java.util.Arrays;

//数字出现的次数
public class Test56 {
    public static void main(String[] args) {
        int[] nums = {3};
        int slove = new Test56().slove(nums);
        System.out.println(slove);
    }

    public int slove(int[] n) {
        Arrays.sort(n);
        int i = 0;
        while (i<n.length-1){
            if (n[i] != n[i + 1]) {
                return n[i];
            }
            i+=3;
        }
        return n[n.length - 1];
    }
}
