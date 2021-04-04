package 阅文;

import MeiTuan.MeiTuan2021_3;

public class Main3 {
    public TreeNode nearestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = nearestCommonAncestor(root.left,p,q);
        TreeNode right = nearestCommonAncestor(root.right,p,q);
        if(left == null) return right;
        else if(right == null) return left;
        else return root;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
