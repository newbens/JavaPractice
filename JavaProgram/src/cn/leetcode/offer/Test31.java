package cn.leetcode.offer;

import java.util.Stack;

public class Test31 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {4,5,3,2,1};
        boolean slove = new Test31().slove(a, b);
        System.out.println(slove);

    }

    public boolean slove(int[] pushed,int[] poped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i : pushed) {
            stack.push(i);
            while (j<poped.length && !stack.empty() && stack.peek() == poped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == poped.length;
    }
}
