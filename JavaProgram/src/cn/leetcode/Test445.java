package cn.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class Test445 {
    public static void main(String[] args) {
        SingleList s = new SingleList();
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(0);
        Node d = new Node(6);
        s.tailAdd(a);
        s.tailAdd(b);
        s.tailAdd(c);
        s.tailAdd(d);
        s.print();
        SingleList s2 = new SingleList();
        Node e = new Node(1);
        Node f = new Node(9);
        Node g = new Node(4);
        s2.tailAdd(e);
        s2.tailAdd(f);
        s2.tailAdd(g);
        s2.print();
        SingleList res = getNum(s, s2);
        res.print();

    }

    public static SingleList getNum(SingleList s1,SingleList s2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (s1.head != null) {          //链表入栈
            stack1.push(s1.head.id);
            s1.head = s1.head.next;
        }
        while (s2.head != null) {
            stack2.push(s2.head.id);
            s2.head = s2.head.next;
        }
        SingleList head = new SingleList();
        int add = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || add > 0) {
            int num1 = stack1.isEmpty() ? 0 : stack1.pop();
            int num2 = stack2.isEmpty() ? 0 : stack2.pop();
            Node node = new Node((num1 + num2 + add) % 10);
            head.headerAdd(node);
            add = (num1+num2+add)/10;
        }
        return head;
    }
}

class Node {
    public int id;
    public Node next;

    public Node(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                '}';
    }
}

class SingleList {
    public Node head;

    public void tailAdd(Node node) {   //尾插法
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }
    public void headerAdd(Node node) {  //头插法
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head= node;
        }
    }
    public void print() {
        ArrayList a = new ArrayList();
        if (head == null) {
            return;
        } else {
            Node temp = head;
            while (temp != null) {
                a.add(temp.id);
                temp = temp.next;
            }
        }
        System.out.println(a);
    }
}
