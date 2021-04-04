package cn.leetcode.offer;

import java.util.Stack;

public class Test58_1 {
    public static void main(String[] args) {
        String s = "   the sky is  blue     ";
        s = s.trim();
        char[] chars = s.toCharArray();
        String temp = "";
        Stack<String> stack = new Stack<>();
        for (int i = 0; i <s.length() ; i++) {
            if (chars[i] == ' ') {
                if (temp != "") {
                    stack.push(temp);
                    temp = "";
                }
            }else {
                temp += chars[i];
            }
        }
        stack.push(temp);
        System.out.println(stack);
        String res = "";
        while (stack.size() > 0) {
            res += stack.pop();
            res += " ";
        }
        System.out.println(res);
    }
}


