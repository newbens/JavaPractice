package cn.leetcode;

import java.util.HashMap;

//最长连续序列
public class Test128 {
    public static void main(String[] args) {
        int[] a = {100, 4, 200, 1, 3, 2};
        int slove = slove(a);
        System.out.println(slove);
    }

    public static int slove(int[] a) {
        int res = 0;
        int left,right;
        HashMap<Integer,Integer> map = new HashMap();
        for (int i : a) {
            left = 0;
            right = 0;
            if (!map.containsKey(i)) {
                if (map.containsKey(i - 1)) {
                    left = map.get(i - 1);
                }
                if (map.containsKey(i + 1)) {
                    right = map.get(i + 1);
                }
                map.put(i, 1 + left + right);
                res = Math.max(res,left+1+right);
            }
        }
        return res;
    }

}
