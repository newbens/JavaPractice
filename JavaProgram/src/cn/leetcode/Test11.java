package cn.leetcode;
//求最大容量
public class Test11 {
    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int res = maxCapacity2(a);
        System.out.println(res);
    }

    public static int maxCapacity(int[] a) {  //方法一：时间复杂度 o(n^2)
        int len = a.length;
        int right = len - 1;
        int max = 0;
        for (int i = 0; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                max = Math.max(max,(j - i) * Math.min(a[i], a[j]));
            }
        }
        return max;
    }

    public static int maxCapacity2(int[] a) {
        int i = 0,j = a.length-1,res = 0;
        while (i < j) {
            if (a[i] < a[j]) {
                //因为容量总是和最低的有关，所以想要找到最大容量就要移动最低得到木板。
                res = Math.max(res, (j - i) * a[i]);
                i ++ ;
            }else{
                res = Math.max(res, (j - i) * a[j]);
                j -- ;
            }
        }
        return res;
    }
}
