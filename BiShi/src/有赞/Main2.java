package 有赞;

import java.util.ArrayList;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args){
        int[] a = {1,2,5};
        int[] b = {2,4};
        int[] ints = new Main2().fairCandySwap(a, b);
        System.out.println(Arrays.toString(ints));
    }
    public int[] fairCandySwap (int[] A, int[] B) {
        int num1 = getSum(A);
        int num2 = getSum(B);
        if (num1 > num2) {
            int[] swap = swap(B, A, num2, num1);
            int t = swap[0];
            swap[0] = swap[1];
            swap[1] = t;
            return swap;
        }else {
            return swap(A, B, num1, num2);
        }
    }

    public int[] swap(int[] a, int[] b,int num1,int num2) {
        int c = (num2-num1)/2;
        for (int i = 0; i < a.length; i++) {
            for (int j = b.length-1; j >= 0 ; j--) {
                if(b[j] <= a[i]) break;
                if(b[j] - a[i] == c) return new int[]{a[i],b[j]};
            }
        }
        return new int[0];
    }

    public int getSum(int[] a){
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            res += a[i];
        }
        return res;
    }
}
