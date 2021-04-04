package cn.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

public class Test202 {
    List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        int n = 18;
        boolean rs = new Test202().get(n);
        System.out.println(rs);
    }

    public  Boolean get(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int res = 0;
        for (int i = 0; i <len ; i++) {
            res += Math.pow(Integer.parseInt(s.substring(i, i + 1)),2);
        }
        if (res == 1) {
            return true;
        }
        if (list.contains(res)) {
            return false;
        }else {
            list.add(res);
        }
        return get(res);
    }
}
