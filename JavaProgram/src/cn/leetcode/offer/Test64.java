package cn.leetcode.offer;

public class Test64 {
    public static Integer res=0;
    public static void main(String[] args) {
        Integer slove = slove(9);
        System.out.println(slove);
    }
    public static Integer slove(int n) {
        boolean x = n > 1 && slove(n - 1) > 0;
        res += n;
        return res;
    }
}
