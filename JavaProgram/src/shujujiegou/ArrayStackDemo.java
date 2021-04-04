package shujujiegou;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack as = new ArrayStack(5);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show: 显示栈");
            System.out.println("push: 入栈");
            System.out.println("pop: 出栈");
            System.out.println("exit: 退出");
            System.out.println("请输入：");
            key = scanner.next();
            switch (key) {
                case "show":
                    as.show();
                    break;
                case "push":
                    System.out.println("请输入想要入栈的值：");
                    int d = scanner.nextInt();
                    as.push(d);
                    break;
                case "pop":
                    as.pop();
                    break;
                case "exit":
                    loop = false;
                    break;

            }
        }
        System.out.println("程序结束！！！");
    }
}

class ArrayStack{
     int maxSize;
     int[] stack;
     int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull(){
        return top == maxSize -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满！！！");
            return;
        }
        top ++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空！！！");
        }
        int value = stack[top];
        top --;
        return value;
    }

    public void show() {      //自顶向下遍历
        if (isEmpty()) {
            System.out.println("栈空！！！");
            return;
        }
        for (int i = top; i >= 0 ; i--) {
            System.out.printf("stack[%d] = %d \n",i,stack[i]);
        }
    }
}