package cn.leetcode.offer;

public class Test33 {
    public static void main(String[] args) {
        int[] a = {1, 3, 2, 6, 5};
        boolean res = new Test33().slove(a);
        System.out.println(res);
    }

    public boolean slove(int[] a) {
        if(a.length == 0) return false;
        return rec(a, 0, a.length - 1);
    }

    public boolean rec(int[] a,int start,int end) {
        if(start >= end)return true;
        int i = start;
        while (a[i] < a[end]) {   //得到左子树下标
            i++;
        }
        int m = i;
        while (a[i] > a[end]) {   //判断右子树是否都小于end
            i++;
        }
        //如果i最后等于end，说明符合规律
        return i == end && rec(a, start, m - 1) && rec(a, m, end-1);  //递归循环左右树
    }
}
