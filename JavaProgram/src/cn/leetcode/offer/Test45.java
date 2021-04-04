package cn.leetcode.offer;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 */
public class    Test45 {
    int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[] a = {3,30,34,5,9};
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < a.length ; i++) {
            s.append(a[i]);
        }
            boolean[] visited = new boolean[a.length];
        int slove = new Test45().slove(s.length(),a, "", visited);
        System.out.println(slove);
    }

    public  int slove(int len,int[] a,String s,boolean[] visited) {
        if (s.length() == len) {
            res = Math.min(res, Integer.valueOf(s));
        }
        for (int i = 0; i < a.length ; i++) {
            if (visited[i] == true) continue;
            visited[i] = true;
            slove(len,a, s + a[i] + "",visited);
            visited[i] = false;
        }
        return res;
    }

    /**
     * 方法二  ：核心思想   若字符串 x+y > y+x 则x>y
     * @param a
     * @return
     */
    public String minNum(int[] a) {
        String[] strs = new String[a.length];
        for (int i = 0; i < a.length ; i++) {
            strs[i] = String.valueOf(a[i]);
        }
        Arrays.sort(strs,(x,y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();
    }
}
