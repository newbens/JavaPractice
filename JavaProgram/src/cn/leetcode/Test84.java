package cn.leetcode;

/*
 Öù×´Í¼×î´ó¾ØÐÎ
 */
public class Test84 {
    public static void main(String[] args) {
        int[] a = {2, 1, 5, 6, 2, 3};
        Integer max = getMax(a);
        System.out.println(max);
    }

    public static Integer getMax(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n ; i++) {
            int hig = nums[i];
            for (int j = i; j < n; j++) {
                hig = Math.min(hig,nums[j]);
                res = Math.max(res,(hig*(j-i+1)));
            }
        }
        return res;
    }
}
