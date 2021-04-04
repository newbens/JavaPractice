package SLL;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args){
        int[] a = {1, 2, 3, 4, 5};
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(test(a, n));
        }
    }

    public static int test(int[] a,int target) {
        int le = 0, ri = a.length - 1;
        while (le < ri) {
            int mid = le + (ri - le) / 2;
            if (a[mid] > target) {
                ri = mid - 1;
            }else {
                le = mid + 1;
            }
        }
        return a[le];
    }
}
