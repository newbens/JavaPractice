package shujujiegou.Sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] a = {53, 3, 542, 748, 14, 214};
        radixSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static int getMax(int[] a) {
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    //基数排序
    public static void radixSort(int[] a) {
        int[][] bucket = new int[10][a.length];
        //定义一维数组记录每个桶放入了数据个数
        int[] bucketElementCount = new int[10];
        for (int i = 1; i < getMax(a); i *= 10) {
            for (int j = 0; j < a.length; j++) {
                //取出每个元素的各位
                int d = a[j] / i  % 10;
                //放入桶中
                bucket[d][bucketElementCount[d]] = a[j];
                bucketElementCount[d]++;
            }
            //取出放入数组
            int index = 0;
            for (int k = 0; k < bucketElementCount.length; k++) {
                if (bucketElementCount[k] > 0) {
                    for (int l = 0; l < bucketElementCount[k]; l++) {
                        a[index] = bucket[k][l];
                        index++;
                    }
                }
                bucketElementCount[k] = 0;  //切记置零！！！！！！！！！！！！！！！！

            }
        }
    }
}
