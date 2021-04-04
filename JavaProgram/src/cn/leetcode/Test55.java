package cn.leetcode;

public class Test55 {
    public static void main(String[] args) {
        int[] num = {2,3,1,1,4};
        int k = 0;
        for (int i = 0; i <num.length ; i++) {
            if (i > k) {
                System.out.println("false");
            }
            k = Math.max(k, i + num[i]);
            System.out.println(k);
            if (k >= num.length-1) {
                System.out.println("true");
                return;
            }
        }
        System.out.println("true");
    }
}
