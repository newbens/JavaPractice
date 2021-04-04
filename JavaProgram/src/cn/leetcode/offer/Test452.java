package cn.leetcode.offer;

//射气球

import java.util.Arrays;
import java.util.Comparator;

public class Test452 {
    public static void main(String[] args) {
        int[][] a = {{10,16},{2,8},{1,6},{7,12}};
        int res = slove(a);
        System.out.println(res);
    }

    public static int slove(int[][] a) {
        if (a.length < 2) {
            return a.length;
        }
        //按照首位排序
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        int count = 1;
        int end = a[0][1];
        for (int i = 1; i < a.length; i++) {
            if (end < a[i][0]) {
                end = a[i][1];
                count++;
            }
        }
        return count;
    }


}
