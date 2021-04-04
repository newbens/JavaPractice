package shujujiegou.Sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] a = {4, 6, 1, 8, 5, 9};
        heapSort(a);
        System.out.println(Arrays.toString(a));

    }

    public static int[] heapSort(int[] a) {
        for (int i = a.length/2-1; i >=0 ; i--) {
            buildHeap(a, i, a.length - 1);
        }
        for (int i = a.length-1; i >=0 ; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            buildHeap(a,0,i-1);
        }
        return a;
    }

    public static void buildHeap(int[] a,int start,int end) {
        int root = start;
        while (true) {
            int child = root * 2 + 1;
            if(child > end) break;
            if(child+1 <= end && a[child+1] > a[child]) child++;
            if (a[child] > a[root]) {
                int temp = a[child];
                a[child] = a[root];
                a[root] = temp;
                root = child;
            } else break;
        }

    }
}


