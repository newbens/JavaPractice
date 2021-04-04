package shujujiegou.Haffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HaffmanTree {
    public static void main(String[] args) {
        int[] a = {13, 7, 8, 3, 29, 6, 1};
        Node head = createHaffmanTree(a);
        System.out.println(head.right.left);
    }

    public static Node createHaffmanTree(int[] a) {
        List<Node> lists = new ArrayList<Node>();
        for (int i : a) {
            lists.add(new Node(i));
        }
        while (lists.size()>1) {
            Collections.sort(lists);
            Node left = lists.get(0);
            Node right = lists.get(1);
            Node parent = new Node(left.val + right.val);
            parent.left = left;
            parent.right = right;
            lists.remove(0);
            lists.remove(0);
            lists.add(parent);
        }
        return lists.get(0);
    }

}

class Node implements Comparable<Node> {
     int val;
     Node left;
     Node right;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.val - o.val;   //从小到大排序
    }
}
