package cn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
//合并数组
public class Test56 {
    public static void main(String[] args) {
        int[][] a = {{1,3},{2,6},{8,10}};
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i <a.length ; i++) {
            list.add(a[i]);
            }
        for (int i = 0; i <list.size()-1 ; i++) {
            if (list.get(i)[1] > list.get(i + 1)[1]) {
                list.remove(i + 1);
                i --;
            } else if (list.get(i)[1] > list.get(i + 1)[0]) {
                list.get(i)[1] = list.get(i + 1)[1];
                list.remove(i + 1);
                i --;
            }
        }
        int[][] res = list.toArray(new int[0][]);
        System.out.println(Arrays.deepToString(res));
        }
    }


