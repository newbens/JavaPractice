package cn.leetcode;

import java.util.Arrays;

/**
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，
 * 即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次
 */
public class Test1371 {
    public static void main(String[] args) {
        String s = "eleetminicoworoep";
        solve(s);
    }

    public static void solve(String s) {
        String[] str = s.split("");
        int[] list = new int[str.length];
        System.out.println(Arrays.toString(str));
        for (int i = 0; i < str.length ; i++) {
            if ("a".equals(str[i])) {
                list[i] = 1;
            }else if("e".equals(str[i])){
                list[i] = 2;
            }else if("i".equals(str[i])){
                list[i] = 3;
            }else if("o".equals(str[i])){
                list[i] = 4;
            }else if("u".equals(str[i])){
                list[i] = 5;
            }else {
                list[i] = 0;
            }
        }
        System.out.println(Arrays.toString(list));
    }

}
