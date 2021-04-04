package cn.leetcode;

/**
 * 实现pow
 */
public class Test50 {
    public static void main(String[] args) {
        double v1 = myPow2(2.0, 10);
        System.out.println(v1);
    }

    public static double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        if (n == 0) {
            return 1f;
        } else if ((n % 2) == 1) {
            return myPow(x, n - 1) * x;
        } else {
            double res = myPow(x, n / 2);
            return res * res;
        }
    }

    public static double myPow2(double x, int n) {
        int p = n;
        double res = 1;
        while (p != 0) {
            if ((p & 1) != 0) { //n为奇数
                res *= x;
            }
            x *= x;
            p /= 2;
        }
        return n > 0 ? res:1/res;
    }
}

