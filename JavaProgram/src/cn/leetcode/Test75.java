package cn.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * ÑÕÉ«·ÖÀà
 */
public class Test75 {
    public static void main(String[] args) {
        int[] a = {2,0,2,1,1,0};
        int[] slove2 = new Test75().slove2(a);
        System.out.println(Arrays.toString(slove2));
    }

    public int[] slove(int[] a) {
        LinkedList<Integer> list = new LinkedList<>();
        int x=0;
        for (int i = 0; i < a.length ; i++) {
            if (a[i] == 0) {
               list.addFirst(a[i]);
               x ++;
            } else if (a[i] == 1) {
                list.add(x,a[i]);
            }else {
                list.addLast(a[i]);
            }
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    public int[] slove2(int[] a) {
        int zero = 0;
        int i = 0;
        int two = a.length;
        while (i < two) {
            if (a[i] == 0) {
                swap(a,i,zero);
                zero ++;
                i ++ ;
            } else if (a[i] == 1) {
                i++;
            }else {
                two --;
                swap(a,i,two);
            }
        }
        return a;
    }

    public void swap(int[] a,int x,int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
