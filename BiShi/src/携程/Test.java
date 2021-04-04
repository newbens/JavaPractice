package 携程;

import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        String c = sc.nextLine();
        System.out.println(reslove(a, b, c));
    }

    public static String reslove(String input, String searchFor, String replaceWith) {
        char[] chars = input.toCharArray();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ']') {
                StringBuilder temp = new StringBuilder();
                while (stack.peek() != '[') {
                    temp.append(stack.pop());
                }
                stack.pop();
                String t = temp.reverse().toString();
                if (t.equals(searchFor)) {
                    char[] chars1 = replaceWith.toCharArray();
                    for (int j = 0; j < chars1.length; j++) {
                        stack.push(chars1[j]);
                    }
                }else {
                    stack.push('[');
                    for (int j = 0; j < t.length(); j++) {
                        stack.push(t.charAt(j));
                    }
                    stack.push(']');
                }
            }else {
                stack.push(chars[i]);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}
