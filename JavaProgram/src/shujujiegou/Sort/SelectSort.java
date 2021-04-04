package shujujiegou.Sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] a = {1, 5, 2, 8, 3, 9, 332, 843, 9};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int index = i;
            for (int j = i+1; j <a.length ; j++) {
                if (a[j] < temp) {
                    temp = a[j];
                    index = j;
                }
            }
            if (index != i) {
                a[index] = a[i];
                a[i] = temp;
            }
        }
    }
}
