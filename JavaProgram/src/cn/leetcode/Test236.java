package cn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class  Test236 {
    public static void main(String[] args) {
        Integer[] a = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode head = new BinaryTree().createTree(a);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode solve = solve(head, p, q);
        System.out.println(solve);
    }

    public static TreeNode solve(TreeNode root, TreeNode p, TreeNode q) {

                if(root == null || root == p || root == q) return root;
                TreeNode left = solve(root.getLeft(), p, q);
                TreeNode right = solve(root.getRight(), p, q);
                if(left == null) return right;
                if(right == null) return left;
                return root;
        }
    }



class TreeNode{
    private Integer val;
    private TreeNode left;
    private TreeNode right;


    public TreeNode(Integer integer) {
        this.val = integer;

    }

    public Integer getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class BinaryTree{
    public static TreeNode createTree(Integer[] a) {
        TreeNode temp =null;
        List<TreeNode> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            list.add(new TreeNode(a[i]));
        }
        for (int i = 0; i <=a.length/2-1 ; i++) {
            temp = list.get(i);
            if(a[2*i+1] != null ) {
                temp.setLeft(list.get(2 * i + 1));
            }
            if(a[2*i+2] != null) {
                temp.setRight(list.get(2 * i + 2));
            }

        }
        return list.get(0);
    }
}
