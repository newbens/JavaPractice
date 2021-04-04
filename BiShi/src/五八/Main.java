package 五八;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        String ys = "+-*/";
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.substring(1, s.length()-1).split("");
        List<String> list = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        String num = "";
        for (int i = 0; i < split.length; i++) {
            if(i ==0 && (split[i].equals("-") || split[i].equals("+"))){
                num += split[0];
                continue;
            }
            if(split[i].equals(" "))continue;
            if (ys.contains(split[i])) {
                list.add(num);
                list.add(split[i]);
                num = "";
            }else {
                num += split[i];
            }
        }
        list.add(num);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("*") || list.get(i).equals("/")) {
                Integer x = Integer.valueOf(stack.pop());
                Integer y = Integer.valueOf(list.get(i + 1));
                Integer res = 0;
                if(list.get(i).equals("*")) res = x * y;
                if(list.get(i).equals("/")) res = x / y;
                stack.push(res+"");
                i++;
            }else stack.push(list.get(i));
        }
        while (stack.size() >= 3) {
            Integer x = Integer.valueOf(stack.pop());
            String pop = stack.pop();
            Integer y = Integer.valueOf(stack.pop());
            if (pop.equals("-")) {
                Integer res = y - x;
                stack.push(res+"");
            }else {
                Integer res = y + x;
                stack.push(res+"");
            }
        }
        System.out.println(stack.pop());
    }
}
