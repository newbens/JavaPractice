package cn.leetcode;

import java.util.Stack;

public class Test42 {
    public static void main(String[] args) {
        int[] list = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Test42 t = new Test42();
        int res = t.getNum(list);
        System.out.printf("可以盛放雨水%d立方米", res);
    }

    private int getNum(int[] list) {
        int res = 0;
        int index = 0;  //下标
        int l = list.length; //数组总长度
        Stack<Integer> stack = new Stack<>();  //栈 用来存放递减的高度
        while (index < l) {    // 遍历数组
            while (stack.size() > 0 && list[index] > list[stack.peek()]) { //如果碰到当前值比栈尾值大 说明存在凹陷，进入循环
                int top = stack.pop();  //弹出栈顶元素
                if (stack.empty()) {   //判断弹出后的栈是否为空，如果为空，说明不存在凹陷，退出循环
                    break;
                }
                int height = Math.min(list[index], list[stack.peek()]) - list[top]; //求凹陷的高
                int chang = index - stack.peek() - 1;  //求凹陷的长
                res += (height * chang);
            }
            stack.push(index);  //比栈尾元素下，说明还是递减，继续入栈
            index += 1; //下标加1
        }
        return res;
    }
}

