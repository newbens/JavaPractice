package cn.leetcode.offer;

import java.util.LinkedList;
import java.util.Queue;

class TNode{
    Integer val;
    TNode left;
    TNode right;

    public TNode(Integer val) {
        this.val = val;
    }
}

public class Test37 {
    public static void main(String[] args) {
        TNode root1 = new TNode(1);
        TNode root2 = new TNode(2);
        TNode root3 = new TNode(3);
        TNode root4 = new TNode(4);
        TNode root5 = new TNode(5);
        root1.left = root2;
        root1.right = root3;
        root3.left = root4;
        root3.right = root5;
        String serialize = new Test37().serialize(root1);
        TNode deserialize = new Test37().deserialize(serialize);
        System.out.println(deserialize.left.val);
    }
    public String serialize(TNode root) {   //序列化
        if(root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TNode node = queue.poll();
            if (node != null) {
                res.append(node.val+",");
                queue.add(node.left);
                queue.add(node.right);
            }else {
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    public TNode deserialize(String data) {  //反序列化
        if (data.equals("[]")) return null;
        String[] list = data.substring(1,data.length()-1).split(",");//按，分隔字符串
        TNode root = new TNode(Integer.valueOf(list[0]));
        int i = 1;
        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TNode node = queue.poll();
            if (!list[i].equals("null")) {
                node.left = new TNode(Integer.valueOf(list[i]));
                queue.add(node.left);
            }
            i ++;
            if (!list[i].equals("null")) {
                node.right = new TNode(Integer.valueOf(list[i]));
                queue.add(node.right);
            }
            i ++;
        }
        return root;
    }

}
