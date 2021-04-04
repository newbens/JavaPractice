package cn.leetcode.offer;

public class Test05 {

    public static void main(String[] args) {
        String s = "3fef grg ge  ";
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                res.append("%20");
            } else {
                res.append(c);
            }
        }
        System.out.println(res);
    }
}

