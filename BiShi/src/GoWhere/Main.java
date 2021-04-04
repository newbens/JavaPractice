package GoWhere;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        BigInteger b = new BigInteger("1");
        BigInteger a = test(m, n);
        while (n > 1) {
            b = b.multiply(BigInteger.valueOf(n));
            n--;
        }
        System.out.println(a.divide(b));

    }

    public static BigInteger test(int m,int n) {
        BigInteger res = new BigInteger("1");
        int a = m - n;
        while (m > a) {
            res = res.multiply(BigInteger.valueOf(m));
            m--;
        }
        return res;
    }
}
