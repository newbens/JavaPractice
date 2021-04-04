package cn.leetcode.offer;

import java.util.LinkedList;
import java.util.List;

/**
 * 字符串的排列组合
 */
public class Test38 {
    static List<String> res = new LinkedList<>();
    public static void main(String[] args) {
        String s = "ABC";
        char[] c = s.toCharArray();
        boolean[] v = new boolean[c.length];
        new Test38().dfs(c,"",v);
        System.out.println(res);
    }

    public void dfs(char[] c,String s,boolean[] visit) {
        if (s.length() == c.length) {
            res.add(s);
            return;
        }
        for (int i = 0; i < c.length ; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            dfs(c, s + c[i], visit);
            visit[i] = false;
        }
    }


}
