package cn.leetcode;

//无重叠子区间

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Test435 {
    @Test
    public void slove() {
        int[][] inters = {{1,2}, {2,3}, {3,4}, {1,3}};
        if (inters.length < 2) System.out.println(inters.length);
        Arrays.sort(inters, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int end = inters[0][1];
        for (int[] inter : inters) {
            int start = inter[0];
            if (start >= end) {
                count++;
                end = inter[1];
            }
        }
        System.out.println(inters.length - count);
    }
}
