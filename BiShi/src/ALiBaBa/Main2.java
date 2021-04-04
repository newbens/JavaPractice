package ALiBaBa;

import java.sql.SQLOutput;
import java.time.Year;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Main2 {
    public static void main(String[] args) {
        int[] a = {2, 5, 73, 26, 4, 39, 9};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] a,int le,int ri) {
        if (le > ri) return;
        int i = le;
        int j = ri;
        int temo = a[le];
        while (i < j) {
            while (i < j &&  temo <= a[j]) j--;
            while (i < j &&  temo >= a[i]) i++;
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
        a[le] = a[i];
        a[i] = temo;
        quickSort(a, le, i - 1);
        quickSort(a,i+1,ri);
    }
}
