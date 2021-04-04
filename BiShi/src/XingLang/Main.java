package XingLang;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args){

    }

    public ArrayList<Integer> post(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(root);
            while (!stack1.isEmpty()) {
                root = stack1.pop();
                stack2.push(root);
                if (root.left != null) {
                    stack1.push(root.left);
                }
                if (root.right != null) {
                    stack1.push(root.right);
                }
            }
            while (!stack2.isEmpty()) {
                res.add(stack2.pop().val);
            }
        }
        return res;
    }

    public static class TreeNode{
        TreeNode left;
        TreeNode right;
        Integer val;

    }
}
