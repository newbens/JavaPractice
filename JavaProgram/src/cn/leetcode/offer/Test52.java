package cn.leetcode.offer;
//两个链表的第一个公共节点
public class Test52 {
    public static void main(String[] args) {
        Node head = new Node(4);
        Node node1 = new Node(1);
        Node node2 = new Node(8);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node_1 = new Node(0);
        Node node_2 = new Node(1);
        Node head_1 = new Node(5);
        node2.next = node3;
        node3.next = node4;
        head.next = node1;
        node1.next = node2;
        head_1.next = node_1;
        node_1.next = node_2;
        node_2.next = node2;
        Node res = slove(head, head_1);
        System.out.println(res.val);
    }

    public static Node slove(Node head1, Node head2) {
        if(head1 == null || head2 == null) return null;
        Node node1 = head1;
        Node node2 = head2;
        while (node1 != node2) {
            node1 = node1 == null ? head1 : node1.next;
            node2 = node2 == null ? head2 : node2.next;
        }
        return node2;
    }



    static class Node{
        public Node next;
        public Integer val;
        public Node(Integer val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", val=" + val +
                    '}';
        }
    }
}
