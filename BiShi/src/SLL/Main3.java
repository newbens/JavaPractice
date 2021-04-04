package SLL;

import java.util.Arrays;

public class Main3 {
    public static void main(String[] args){
        int[] a = {1, 2, 3, 4, 5};
        int[] in = {3, 0, 7, 2, 5};
        test(a,in);
    }

    public static void test(int[] a,int[] in) {
        Arrays.sort(a);
        int le = 0, ri = a.length - 1;
        for (int i = 0; i < a.length; i++){
            while (le < ri) {
                int mid = le + (ri - le) / 2;
                if (in[i] > a[mid]) {
                    le = mid + 1;
                }else if(in[i] < a[mid]){
                    ri = mid - 1;
                }else {
                    System.out.println(in[i]);
                    break;
                }
            }
            System.out.println(le);
        }
    }
}
