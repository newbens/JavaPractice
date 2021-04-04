package cn.leetcode.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Test32_3 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(9);
        TreeNode root3 = new TreeNode(20);
        TreeNode root4 = new TreeNode(15);
        TreeNode root5 = new TreeNode(7);
        root1.left = root2;
        root1.right = root3;
        root3.left = root4;
        root3.right = root5;

        List<List<Integer>> lists = levelOrder(root1);
        System.out.println(lists);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)return null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> help = new ArrayList<>();
        List<TreeNode> help2 = new ArrayList<>();
        queue.offer(root);
        int sum = 0;
        while(queue.size() > 0){
            TreeNode node = queue.removeFirst();
            help.add(node.val);
            if(node.left != null)help2.add(node.left);
            if(node.right != null)help2.add(node.right);
            if(queue.size() == 0){
                for(int i = 0;i < help2.size();i ++){
                    queue.offer(help2.get(i));
                }
                if((sum/2)== 1){
                    Collections.reverse(help);
                }
                res.add(help);
                sum ++;
                help = new ArrayList<>();
                help2 = new ArrayList<>();
            }
        }
        return res;
    }
}
