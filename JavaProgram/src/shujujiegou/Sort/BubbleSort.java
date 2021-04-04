package shujujiegou.Sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {2, 4, 82, 339, 4, 30};
        sort(a);
        System.out.println(Arrays.toString(a));

    }

    public static void sort(int[] arr) {                  //冒泡排序  稳  n^2
        for (int i = 0; i < arr.length - 1 ; i++) {
            for (int j = 0; j < arr.length - 1 - i  ; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }



    public static void sort2(int[] arr) {                  //鸡尾酒排序
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
}
