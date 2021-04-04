package cn.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//∞¥’’…Ì∏ﬂ≈≈–Ú
public class Test406 {
    @Test
    public void slove() {
        int[][] a = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o2[0] - o1[0];
                return o1[1] - o2[1];
            }
        });
        List<int[]> list = new LinkedList<>();
        for (int i = 0; i <a.length ; i++) {
            list.add(a[i][1],a[i]);
        }
    }
}
