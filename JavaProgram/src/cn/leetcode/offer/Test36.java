package cn.leetcode.offer;

//二叉搜索树 转双向链表
public class Test36 {
    TreeNode head;
    TreeNode pre;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        TreeNode res = new Test36().slove(root);
        System.out.println(res.val);
    }

    public TreeNode slove(TreeNode root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(TreeNode root) {  //left指向前面的节点， pre的right指向自己的后节点，形成双向链表
        if(root == null) return;
        dfs(root.left);
        if(pre == null) head = root;
        else pre.right = root;
        root.left = pre;
        pre = root;
        dfs(root.right);
    }

}

