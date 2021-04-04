package cn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Çó×Ó¼¯
 */
public class Test78 {
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int[] a = {1, 2, 3,4};
        new Test78().backtrace(new ArrayList<Integer>(),0,a);
        System.out.println(res);
    }

    public void backtrace(ArrayList<Integer> temp,int i,int[] a) {
        res.add(new ArrayList<>(temp));
        for (int j = i; j < a.length; j++) {
            temp.add(a[j]);
            backtrace(temp,j+1,a);
            temp.remove(temp.size() - 1);
        }
    }
}
