package JiBiTe;

import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextInt();
        long y = sc.nextInt();
        long z = sc.nextInt();
        long n = sc.nextInt();
        long xa = sc.nextInt();  //b
        long ya = sc.nextInt();  //c
        long xb = sc.nextInt();  //a
        long yb = sc.nextInt();  //c
        long xc = sc.nextInt();  //a
        long yc = sc.nextInt();  //b
        while (n > 0) {
            long a = y * xb + xc * z; //每日增量
            long b = xa * x + yc * z;
            long c = ya * x + yb * y;
            x += a;
            x %= 1000000007;
            y += b;
            y %= 1000000007;
            z += c;
            z %= 1000000007;
            n--;
        }
        System.out.println(x+" "+y+" "+z);
    }
}
