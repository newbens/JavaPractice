package cn.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Test95 {
    public static void main(String[] args) {
        int i = 3;
        List<TreeNode> res = new Test95().slove(1, 3);
        System.out.println(res);
    }

    public List<TreeNode> slove(int start,int end) {
        List<TreeNode> res = new LinkedList<>();
        if(start > end){
            res.add(null);
            return res;
        }
        if(start == end){
            res.add(new TreeNode(start));
            return res;
        }
        for (int i = start; i <= end ; i++) {
            List<TreeNode> leftTree = slove(start, i-1); //�õ�����ڵ����������������
            List<TreeNode> rightTree = slove(i + 1, end); //�õ�����ڵ����������������
            for (TreeNode left : leftTree) { //������������ӵ��ڵ���
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.setLeft(left);
                    root.setRight(right);
                    res.add(root);
                }
            }
        }
        return res;
    }
}
