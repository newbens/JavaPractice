package cn.leetcode;

import java.util.Stack;

public class Test151 {
    public static void main(String[] args) {
        String s = "  hello world!  ";
        String res = new Test151().getStr(s);
        String res2 = new Test151().getStr2(s);
        System.out.println(res);
        System.out.println(res2);
        System.out.println(res.equals(res2));
    }

    public String getStr(String s) {
        s = s.trim();   //去掉前后空格
        s += " ";
        String str = "";
        Stack<String> stack = new Stack<>();
        for (int index = 0; index < s.length() ; index++){
            String ch = s.substring(index, index + 1);
            if (ch.charAt(0) == ' ') {
                if (str != "") {
                    stack.push(str);
                    stack.push(" ");
                    str = "";
                }else{
                    continue;
                }
            }else{
                str += ch;
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res.trim();
    }

    public String getStr2(String s) {
        s = s.trim();
        String [] spString = s.split("\\s+");
        String res = "";
        for (int i = spString.length-1; i >= 0 ; i--) {
            if (i == 0) {
                res += spString[i];
            }else{
                res += spString[i];
                res += " ";
            }
        }
        return res;
    }
}
