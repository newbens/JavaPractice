package cn.leetcode;

public class Test1014 {
    public static void main(String[] args) {
        int[] a = {8,1,5,2,6};
        int slove = slove(a);
        System.out.println(slove);
    }

    public static int slove(int[] a) {
        int len = a.length;
        int mx = a[0];
        int res = a[0];
        for (int i = 1; i < len ; i++) {
            res = Math.max(res, mx + a[i] - i);
            mx = Math.max(mx, a[i] + i);
        }
        return res;
    }
}
