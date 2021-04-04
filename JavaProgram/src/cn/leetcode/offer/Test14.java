package cn.leetcode.offer;

//剪绳子
public class Test14 {
    public static void main(String[] args) {
        int n =10;
        int slove = slove2(n);
        System.out.println(slove);
    }

    public static int slove(int n) {    //解法一
        if (n <= 3) return n-1;
        int a = n/3;
        int b = n % 3;
        if(b == 0) return (int) Math.pow(3, a);
        if(b == 1) return (int) Math.pow(3, a-1)*4;
        return (int) Math.pow(3, a) * 2;
    }

    public static int slove2(int n) {    //解法二
        if(n <= 3)return n-1;
        int res = 1;
        while (n > 4) {
             res *= 3;
            n -= 3;
        }
        return res * n;
    }
}
