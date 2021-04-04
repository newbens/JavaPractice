package shujujiegou;

public class Calculator {
    public static void main(String[] args) {
        String s = "3-2*6-2";
        ArrayStack2 numStack = new ArrayStack2(10); //存放数的栈
        ArrayStack2 operStack = new ArrayStack2(5); //存放操作符的栈
        //扫描器
        int index = 0;
        int x, y, res;
        char ch = ' ';
        char oper = ' ';
        while (true) {
            ch = s.substring(index, index + 1).charAt(0);   //每次取一个字符
            if (operStack.isOper(ch)) {
                if (operStack.isEmpty()) {
                    operStack.push(ch);
                } else {
                    if (operStack.priority(ch) <= operStack.priority((char) operStack.peek())) {
                        x = numStack.pop();     //弹出两个数
                        y = numStack.pop();
                        oper = (char) operStack.pop();   //弹出操作符
                        char pre = (char) operStack.peek();
                        res = numStack.cal(x, y, oper);   //计数
                        numStack.push(res);    //将得出的值push进栈
                        operStack.push(ch);    // 将当前操作符push进栈
                    } else {
                        operStack.push(ch);
                    }
                }

            } else {  //如果是数直接入栈
                numStack.push(ch - 48);   //字符1对应的ascll码为49
            }
            index++;
            if (index >= s.length()) {   //当index等于字符串长度时，退出
                break;
            }
        }
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            x = numStack.pop();     //弹出两个数
            y = numStack.pop();
            oper = (char) operStack.pop();   //弹出操作符
            if (!operStack.isEmpty()){
            char pre = (char)operStack.pop();
                if (pre == '-') {
                 y = y * -1;
                 operStack.push('+');
             }else{
                    operStack.push(pre);
                }
            }
            System.out.printf("x: %d ,y : %d , oper :  %s  \n",x,y,oper);
            res = numStack.cal(x, y, oper);   //计数
            numStack.push(res);    //将得出的值push进栈
        }
        System.out.printf("表达式%s = %d", s, numStack.pop());
    }
}

class ArrayStack2 extends ArrayStack {
    public ArrayStack2(int maxSize) {
        super(maxSize);
    }

    //返回优先级 数字越大优先级越高
    public int priority(char oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是否是运算符
    public boolean isOper(char oper) {

        return oper == '+' || oper == '-' || oper == '*' || oper == '/';
    }

    public int peek() {
        return stack[top];
    }


    //计算
    public int cal(int x, int y, char op) {
        int res = 0;
        switch (op) {
            case '-':
                res = y - x;
                break;
            case '+':
                res = y + x;
                break;
            case '*':
                res = y * x;
                break;
            case '/':
                res = y / x;
                break;
        }
        return res;
    }


}