package 五八;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n+1];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            int num = getCount(i);
            a[i] = num;
        }
        System.out.println(Arrays.toString(a));
    }

    public static int getCount(int n) {
        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }
}
