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
        int dep = 0;//���
        int start = 0;//�������ֿ�ʼ���±�

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            char p = s.charAt(i - 1);
            if (c == '-' && p != '-') { //˵����ʱ������������
                int val = Integer.valueOf(s.substring(start, i));
                //˵����ʱ�������Ľڵ�֮ǰ�Ľڵ㶼������ڵ��ͬһ�������һ�㣬ջҪ���ֵ�����������Ҫpop��ȥ������
                while (stack.size() > 1 && stack.peek().dep >= dep) {
                    NewNode child = stack.pop();
                    buildTree(stack.peek(), child);
                }
                stack.push(new NewNode(new TreeNode(val), dep));//��Ԫ����ջ
                dep = 1; //�������
                start = i + 1;
            }
            if (c == '-' && p == '-') {
                dep++;
                start = i + 1;
            }
        }

        //�����һ��δ��ջ��Ԫ�ؽ�ջ
        int val = Integer.valueOf(s.substring(start, s.length()));
        while (!stack.isEmpty() && stack.peek().dep >= dep) {
            NewNode child = stack.pop();
            buildTree(stack.peek(), child);
        }
        stack.push(new NewNode(new TreeNode(val), dep));//��Ԫ����ջ

        while (stack.size() > 1) {
            NewNode c = stack.pop();
            buildTree(stack.peek(), c);
        }
        return stack.peek().n;//���ظ��ڵ� ����ջ�е����һ��Ԫ��һ���Ǹ��ڵ�
    }

    public void buildTree(NewNode p, NewNode c) {//����
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
        this.n = n;//���ڵ�
        this.dep = dep;//��ǰ�ڵ����
    }
}


