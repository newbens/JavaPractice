package cn.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

public class Test48 {
    static int res = 0;
    public static void main(String[] args) {
        String s = "abba";
        new Test48().slove(s);
        System.out.println(res);
    }

    public void slove(String s) {
        int i = -1;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j);
            res = Math.max(res, j - i);
            j++;
        }
    }
}
