package cn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test22 {
    public static void main(String[] args) {
    }

    public void solve(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) {
            System.out.println("输入有误！！");
        }
        dfs("",n,n,list);
        System.out.println(list);

    }

    public static void dfs(String curString,int left,int right,List<String> list) {
        if (left == 0 && right == 0) {
            list.add(curString);
            return;
        }
        if (right > left) {
            return;
        }
        if (left > 0) {
            dfs(curString + "）", left - 1, right, list);
        }
        if (right > 0) {
            dfs(curString + "（", left, right - 1, list);
        }
    }
}
