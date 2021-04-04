package cn.leetcode;

import java.util.Stack;

public class Test1028 {
    public static void main(String[] args) {
        String s = "1-2--3--4-5--6--7";
        TreeNode root = new Test1028().recoverFromPreorder(s);
        System.out.println(root.getVal());
    }
    public TreeNode recoverFromPreorder(String s) {
        Stack<NewNode> stack = new Stack();
        int dep = 0;//深度
        int start = 0;//保存数字开始的下标

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            char p = s.charAt(i - 1);
            if (c == '-' && p != '-') { //说明此时遍历到了数字
                int val = Integer.valueOf(s.substring(start, i));
                //说明此时遍历到的节点之前的节点都是这个节点的同一层或者下一层，栈要保持单调递增，需要pop出去建树。
                while (stack.size() > 1 && stack.peek().dep >= dep) {
                    NewNode child = stack.pop();
                    buildTree(stack.peek(), child);
                }
                stack.push(new NewNode(new TreeNode(val), dep));//新元素入栈
                dep = 1; //重置深度
                start = i + 1;
            }
            if (c == '-' && p == '-') {
                dep++;
                start = i + 1;
            }
        }

        //将最后一个未进栈的元素进栈
        int val = Integer.valueOf(s.substring(start, s.length()));
        while (!stack.isEmpty() && stack.peek().dep >= dep) {
            NewNode child = stack.pop();
            buildTree(stack.peek(), child);
        }
        stack.push(new NewNode(new TreeNode(val), dep));//新元素入栈

        while (stack.size() > 1) {
            NewNode c = stack.pop();
            buildTree(stack.peek(), c);
        }
        return stack.peek().n;//返回根节点 留在栈中的最后一个元素一定是根节点
    }

    public void buildTree(NewNode p, NewNode c) {//建树
        if (p.n.getLeft() == null) {
            p.n.setLeft(c.n);
        } else {
            p.n.setRight(c.n);
        }
    }
}

class NewNode {
    TreeNode n;
    int dep;

    public NewNode(TreeNode n, int dep) {
        this.n = n;//树节点
        this.dep = dep;//当前节点深度
    }
}


