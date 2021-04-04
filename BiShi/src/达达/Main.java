package 达达;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(check(s));
    }

    public static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ']') {
                Character pop = stack.pop();
                if (pop != '[') {
                    return false;
                }
            } else if (chars[i] == ')') {
                Character pop = stack.pop();
                if (pop != '(') {
                    return false;
                }
            } else if (chars[i] == '}') {
                Character pop = stack.pop();
                if (pop != '{') {
                    return false;
                }
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }
}
