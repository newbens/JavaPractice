package cn.leetcode;

import java.util.HashMap;

//ÖØ¸´Êı×Ö
public class Test03 {
    public static void main(String[] args) {
        int[] a = {2,3,1,0,2,3,5};
        Integer slove = slove(a);
        System.out.println(slove);
    }

    public static Integer slove(int[] a) {
        int res = -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : a) {
            if (!map.containsKey(i)) {
                map.put(i,0);
            }else {
                res = i;
                break;
            }
        }
        return res;
    }
}
