package cn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 求公共前缀和
 */
public class Test14 {
    public static void main(String[] args) {
        String[] strings = {"flower","flow","flight"};
        String slove = new Test14().slove(strings);
        System.out.println(slove);
        List list = new ArrayList();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
    }

    public String slove(String[] strings) {
        String res = strings[0];
        for (int i = 1; i < strings.length; i++) {
            int j = 0;
            for (; j < strings[i].length() && j < res.length() ; j++) {
                if (res.charAt(j) != strings[i].charAt(j)) {
                    break;
                }
            }
            if (j == 0) {
                return "";
            }
            res = res.substring(0, j);
        }
        return res;
    }
}
