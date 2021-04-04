package cn.leetcode.offer;

//���������� ת˫������
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

    public void dfs(TreeNode root) {  //leftָ��ǰ��Ľڵ㣬 pre��rightָ���Լ��ĺ�ڵ㣬�γ�˫������
        if(root == null) return;
        dfs(root.left);
        if(pre == null) head = root;
        else pre.right = root;
        root.left = pre;
        pre = root;
        dfs(root.right);
    }

}

