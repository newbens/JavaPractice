package cn.leetcode.offer;

import java.util.LinkedList;
//列表最大值
public class Test59_2 {
    LinkedList<Node> list;

    public Test59_2() {
        list = new LinkedList<>();
    }

    public int max_value() {
        return list.peek().getMax();
    }

    public void push_back(int value) {
        Node temp = new Node();
        temp.setVal(value);
        if (list.size() == 0) {
            temp.setMax(value);
        } else {
            temp.setMax(Math.max(value, list.peek().getMax()));
        }
        list.addFirst(temp);
    }

    public int pop_front() {
        Node poll = list.removeLast();
        return poll.getVal();
    }

    public static void main(String[] args) {
        Test59_2 t =  new Test59_2();
        t.push_back(1);
        t.push_back(2);
        int x = t.max_value();
        int y = t.pop_front();
        int z = t.max_value();
        System.out.println(x+"  " +
                y+"  "+z);
    }
}


class Node {
    private Integer val;
    private Node next;
    private Integer max;

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }
}
