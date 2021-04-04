package Wangyi;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class WangYi15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n ; i++) {
            a[i] = sc.nextInt();

        }
        int abs = 0;
        int index = 0;
        for (int i = 1; i < n; i++) {
            if(Math.abs(a[i]-a[i-1]) > abs){
                abs = Math.abs(a[i] - a[i - 1]);
                index = i;
            }
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(a[0]);
        stack2.push(a[index]);
        for (int i = 2; i < n; i++) {
            if (Math.abs(stack1.peek() - a[i]) > Math.abs(stack2.peek() - a[i])) stack2.push(a[i]);
            else stack1.push(a[i]);
        }
        int res = 0;
        while (stack1.size() > 1) {
            res += Math.abs(stack1.pop() - stack1.peek());
        }
        while (stack2.size() > 1) {
            res += Math.abs(stack2.pop() - stack2.peek());
        }
        System.out.println(res);
    }
}