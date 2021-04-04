package 用友;


import org.junit.Test;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        String s = "3[b2[ac]]";
        System.out.println(new Main3().decodeString(s));
    }

    public String decodeString(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ']') {
                StringBuilder temp = new StringBuilder();
                while (stack.size() > 0) {
                    Character pop = stack.pop();
                    if(pop == '[')break;
                    else temp.append(pop);
                }
                temp.reverse();
                StringBuilder num = new StringBuilder();
                while (stack.size() > 0) {
                    Character pop = stack.pop();
                    if(pop -'0' > 10){
                        stack.push(pop);
                        break;
                    }
                    else num.append(pop);
                }
                num.reverse();
                int number = 0;
                if (num != null) {
                    number = Integer.valueOf(String.valueOf(num))-1;
                }
                StringBuilder t = new StringBuilder(temp);
                while (number > 0) {
                    number--;
                    t.append(temp);
                }
                char[] chars1 = t.toString().toCharArray();
                for (int j = 0; j < chars1.length; j++) {
                    stack.push(chars1[j]);
                }
            } else stack.push(chars[i]);
        }
        StringBuilder res = new StringBuilder();
        while (stack.size() > 0) {
            res.append(stack.pop().toString());
        }
        return res.reverse().toString();
    }


}
