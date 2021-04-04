package cn.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

public class Test50 {
    public static void main(String[] args) {
        String s = "aaaccdeff";
        int[] a = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            a[i] = 1;
            if (map.containsKey(s.charAt(i))) {
                a[i] += 1;
                a[map.get(s.charAt(i))] += 1;
            }else {
                map.put(s.charAt(i),i);
            }

        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                System.out.println(s.charAt(i));
                break;
            }
        }
    }
}
