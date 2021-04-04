package cn.leetcode;

import java.util.Arrays;

//ת������
public class Test1300 {
    /**
     *  sum1:��������
     *  sum2������޸ĺ�������
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
            //����޸ĺ������� ��֮ǰ�Ĵ�˵��֮ǰ��������
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
