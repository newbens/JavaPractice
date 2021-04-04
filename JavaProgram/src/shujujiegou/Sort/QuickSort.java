package shujujiegou.Sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 52, -6, 9, 230, 46, 80, 56, 41, 2};
        fastSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void fastSort(int[] a,int start,int end) {
        if(start > end) return;
        int i = start, j = end, t = a[start];
        while (i < j) {
            while (i < j && t <= a[j]) j--;
            while (i < j && t >= a[i]) i++;
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        a[start] = a[i];
        a[i] = t;
        fastSort(a,start,i-1);
        fastSort(a,i+1,end);

    }
}


