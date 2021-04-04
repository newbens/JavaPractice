package shengzhou;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7,8,9};
        int[] b = {10};
        int num = 2;
        test(a,num);
    }

    public static void test(int[] a,int num) {
        int[] newa = new int[num];
        int len = a.length;
        int start = 0;
        for (int i = len-num; i < len; i++) {
            newa[start++] = a[i];
        }
        for (int i = len - 1; i >  num - 1; i--) {
            a[i] = a[i - num];
        }
        for (int i = 0; i < num; i++) {
            a[i] = newa[i];
        }
        System.out.println(Arrays.toString(a));
    }
}
