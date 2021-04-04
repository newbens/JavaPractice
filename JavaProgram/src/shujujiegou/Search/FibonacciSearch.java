package shujujiegou.Search;

import java.util.Arrays;

public class FibonacciSearch {
    public static void main(String[] args) {
        int[] a = {1, 8, 10, 89, 1000, 1234};
        int[] f = new int[20];
        for (int i = 0; i < f.length; i++) {
            f[i] = fiBo(i);
        }
        System.out.println(Arrays.toString(f));

    }

    public static int fiBo(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return fiBo(n - 1) + fiBo(n - 2);
        }


    }
}
//    public static int fibonacciSearch(int[] a,int key) {
//        int low = 0;
//        int high = a.length;
//
//
//    }
//}
