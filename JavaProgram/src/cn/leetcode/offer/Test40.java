package cn.leetcode.offer;

import java.util.Arrays;

/**
 * 最小的k个数
 */
public class Test40 {
    public static void main(String[] args) {
        int[] a = {0,1,2,1};
        int k = 1;
        int[] res = new int[k];
        for (int i = a.length/2-1; i >= 0 ; i--) {
            buildHeap(a,i,a.length-1);
        }
        for (int i = 0; i < k ; i++) {
            res[i] = a[0];
            int temp = a[0];
            a[0] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
            buildHeap(a, 0, a.length - 2 - i);
        }
        System.out.println(Arrays.toString(res));
    }

    public static void buildHeap(int[] a, int start, int end) {
        int root = start;
        while (true) {
            int child = root * 2 + 1;
            if (child > end) break;
            if (child + 1 <= end && a[child] > a[child + 1]) {
                child = child + 1;
            }
            if (a[child] < a[root]) {
                int temp = a[child];
                a[child] = a[root];
                a[root] = temp;
                root = child;
            }else {
                break;
            }
        }

    }
}

