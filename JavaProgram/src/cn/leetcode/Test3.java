package cn.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Test3 {
    public static void main(String[] args) {
        String s = "pwwkew";
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int num = 0;
        for (int i = 0; i < s.length() ; i++) {
            if (map.containsKey(s.charAt(i))) {
                num = Math.max(num, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i-num+1);
        }
        System.out.println(res);
    }
}
