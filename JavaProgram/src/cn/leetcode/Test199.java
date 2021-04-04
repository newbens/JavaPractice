package cn.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Test199 {

    List<Integer> res = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        root1.setLeft(root2);
        root1.setRight(root3);
        root2.setLeft(root4);
        root2.setRight(root5);
        List<Integer> list = new Test199().rightSideView(root1);
        System.out.println(list);

    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)return res;
        cengxu(root);
        return res;
    }

    public void cengxu(TreeNode root){
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> help = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            boolean flag = true;
            int n = queue.size();
            for(int i = 0;i < n; i++){
                TreeNode temp = queue.poll();
                if(flag && (temp != null)){
                    res.add(temp.getVal());
                    flag = false;
                }
                if(temp.getRight() != null)help.add(temp.getRight());
                if(temp.getLeft() != null)help.add(temp.getLeft());
            }
            if ( !help.isEmpty()) {
                queue.addAll(help);
                help.clear();
            }
        }
    }

    /**
     * 解法二
     * @param root
     * @param dep
     */
    public void slove2(TreeNode root,int dep) {
        if(root == null)return;
        if (res.size() == dep) {  //说明刚刚到达下一层 将第一个节点加入 并且dep深度+1.
            res.add(root.getVal());
        }
        dep ++;
        slove2(root.getRight(),dep);
        slove2(root.getLeft(),dep);
    }

}
