package shujujiegou.Sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {     //插入排序  稳定  最差n^2   平均n^2  最好 n
        int[] arr = {-5, 6, 2, 3, 8, 4};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length ; i++) {
            int insertValue = arr[i];
            int index = i-1;
            while (index > 0 && insertValue < arr[index]) {
                arr[index + 1] = arr[index];
                index --;
            }
            arr[index + 1] = insertValue;
        }


    }
}
