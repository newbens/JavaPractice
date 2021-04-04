package cn.leetcode.offer;

public class Test16 {
    public static void main(String[] args) {
        int n = 2;
        double x = 2.1;
        double v = new Test16().myPow(x, n);
        System.out.println(v);
    }

    public double myPow(double x,long n) {
        if( n == 0 || x == 0 )return 1;
        if (n % 2 == 0) {
            double s = myPow(x, n / 2);
            return s * s;
        }else {
            double v = myPow(x, (n - 1) / 2);
            return v * v * x;
        }
    }
}
