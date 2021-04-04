package shujujiegou.Sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {   //交换法
        int temp = 0;
        for (int grep = arr.length/2; grep >0 ; grep/=2) {
            for (int i = grep; i <arr.length ; i++) {
                for (int j = i-grep; j >= 0 ; j -= grep) {
                    if (arr[j] > arr[j + grep]) {
                        temp = arr[j];
                        arr[j] = arr[j + grep];
                        arr[j + grep] = temp;
                    }
                }
            }

        }
    }

    public static void shellSort2(int[] arr) {    //插入法
        for (int i = arr.length/2; i > 0  ; i /= 2) {
            for (int j = i; j < arr.length ; j++) {
                int index = j;
                int temp = arr[index];
                if (arr[index] < arr[index - i]) {
                    while (index - i > 0 && temp < arr[index - i]) {
                        arr[index] = arr[index - i];
                        index -= i;
                    }
                }
            }

        }
    }

}
