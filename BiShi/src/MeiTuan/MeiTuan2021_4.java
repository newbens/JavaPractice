package MeiTuan;

import jdk.internal.dynalink.beans.StaticClass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class MeiTuan2021_4 {
    static int money;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
           pushInStack(stack,a[i]);
        }
        System.out.println(money);
    }

    public static void pushInStack(Stack<Integer> stack,int i) {
        if (!stack.isEmpty() && i == stack.peek()) {
            money ++ ;
            Integer pop = stack.pop();
            pushInStack(stack,pop+1);
        }else {
            stack.push(i);
        }
    }
}
