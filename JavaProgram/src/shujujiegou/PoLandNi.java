package shujujiegou;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
//   逆波兰
public class PoLandNi {
    public static void main(String[] args) {
//        String ex = "30 4 + 5 * 6 -";  //逆波兰表达式
        String ex = "1+((2+3)*4)-5";
//        List res = getList(ex);
//        int result = getSum(res);
//        System.out.println(result);
          List s = ExList(ex);
          System.out.println(s);
        List suffic = TransForSuffic(s);
        System.out.println(suffic);
        int res = getSum(suffic);
        System.out.println(res);


    }

    public static List<String> getList(String s) {
        String[] split = s.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    public static List<String> ExList(String ex) {
        int index = 0;  //索引指针
        List<String> res = new ArrayList<>();
        char c;
        String s;
        do {
            if ((c = ex.charAt(index)) < 48 || (c = ex.charAt(index)) > 57) {  //如果是运算符直接add
                res.add(c + "");
                index ++;
            }else {
                s = "";
                while (index < ex.length() && (c = ex.charAt(index)) >= 48 && (c = ex.charAt(index)) <= 57) {
                    s += c;   //拼接
                    index ++ ;
                }
                res.add(s);
            }
        } while (index < ex.length());
        return res;
    }

    public static List<String> TransForSuffic(List<String> list) {
        Stack<String> s1 = new Stack<>();   //符号栈
        List<String> ls = new ArrayList<>();  //保存最后结果的数组
        for (String s : list) {
            if (s.matches("\\d+")) {    //如果是数字，直接加入ls
                 ls.add(s);
            }else if(s.equals("(")){       //如果是左括号直接加入
                s1.push(s);
            } else if (s.equals(")")) {    //如果是右括号，则s1 pop出( 之前的所有数和运算符
                while (!s1.peek().equals("(")) {
                    ls.add(s1.pop());
                }
                s1.pop();  //消掉一对括号
            } else {
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(s)) {
                    ls.add(s1.pop());
                }
                s1.push(s);
            }
        }
        while (s1.size() != 0) {
            ls.add(s1.pop());
        }
        return ls;
    }

    public static int getSum(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String s : list) {
            if (s.matches("\\d+")) {   //匹配多位数
                stack.push(s);
            } else {   //pop出两个数运算
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (s.equals("+")) {
                    res = num1+num2;
                } else if (s.equals("-")) {
                    res = num1-num2;
                } else if (s.equals("*")) {
                    res = num1*num2;
                } else if (s.equals("/")) {
                    res = num1/num2;
                }else{
                    throw new RuntimeException("输入错误！！！");
                }
                stack.push(res+"");  //转字符串！！
            }
        }

    return Integer.parseInt(stack.pop());

    }
}

class Operation{
    private static int ADD = 1;
    private static int SUB = 1;
    private static  int MUL = 2;
    private static  int DIV = 2;

    public static int getValue(String s) {
        int res = 0;
        switch (s) {
            case "+":
                res = ADD;
                break;
            case "-":
                res = SUB;
                break;
            case "*":
                res = MUL;
                break;
            case "/":
                res = DIV;
                break;
        }
        return res;
    }

}