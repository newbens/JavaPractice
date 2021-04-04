package test.cn.leetcode;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a = {2, 6, 9, 3, 0, 4, 12};
//        quickSort(a,0,a.length-1);
        new Test().heapSort(a);
        System.out.println(Arrays.toString(a));
    }
    //¿ìËÙÅÅÐò
    public static void  quickSort(int[] a,int lo,int hi) {
        if (lo > hi) {
            return;
        }
        int i,j,temp,t;
        i = lo;
        j = hi;
        temp = a[lo];
        while (i < j) {
            while (i < j && a[j] >= temp) {
                j--;
            }
            while (i < j && a[i] <= temp) {
                i ++;
            }
            t = a[j];
            a[j] = a[i];
            a[i] = t;
        }
        a[lo] = a[i];
        a[i] = temp;
        quickSort(a,lo,i-1);
        quickSort(a,i+1,hi);
    }

    //¶ÑÅÅÐò
    public void buildHeap(int[] a,int start,int end) {
        int root = start;
        while (true) {
            int child = root * 2 + 1;
            if (child > end) {
                return ;
            }
            if (child + 1 <= end && a[child] < a[child + 1]) {
                child = child + 1;
            }
            if (a[child] > a[root]) {
                int temp = a[child];
                a[child] = a[root];
                a[root] = temp;
                root = child;
            }else {
                break;
            }
        }
    }

    public void heapSort(int[] a) {
        int end = a.length - 1;
        for (int i = end/2-1; i >= 0;i--) {
            buildHeap(a,i,end);
        }
        for (int i = end; i >= 0 ; i--) {
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            buildHeap(a,0,i-1);

        }

    }
}
