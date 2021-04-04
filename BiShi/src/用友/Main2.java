package 用友;

import java.util.Stack;

public class Main2 {
    public static void main(String[] args) {
        String s = "{{*}";
        System.out.println(new Main2().checkStr(s));
    }

    public boolean checkStr(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        if (chars[0] == '}') return false;
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '{') {
                stack.push(chars[i]);
            } else if (chars[i] == '}') {
                if (stack.size() == 0) count--;
                else {
                    stack.pop();
                }
            } else if (chars[i] == '*') {
                count++;
            } else continue;
        }
        if (stack.size() == 0 || stack.size() == count) return true;
        return false;
    }
}
