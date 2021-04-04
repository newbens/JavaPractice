package cn.leetcode;

import java.util.Arrays;

//转变数组
public class Test1300 {
    /**
     *  sum1:存放数组和
     *  sum2；存放修改后的数组和
     */
    private int sum1, sum2;

    public static void main(String[] args) {
        int[] a = {4, 9, 3};
        int target = 10;
        int bestValue = new Test1300().findBestValue(a, target);
        System.out.println(bestValue);
    }


    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int avg = target / arr.length;
        int idx = findValue(0, avg, arr);
        int diff = Math.abs(sum2 - target);
        while (true) {
            idx = findValue(idx, ++avg, arr);
            int temp = Math.abs(sum2 - target);
            //如果修改后的数组和 比之前的大，说明之前的是最优
            if (temp >= diff)
                return avg - 1;
            diff = temp;
        }
    }

    private int findValue(int idx, int avg, int[] arr) {
        for (; idx < arr.length; ++idx) {
            if (arr[idx] >= avg) {
                sum2 = sum1 + avg * (arr.length - idx);
                return idx;
            }
            sum1 += arr[idx];
        }
        return idx;
    }


}
