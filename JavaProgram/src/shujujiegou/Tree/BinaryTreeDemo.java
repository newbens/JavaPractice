package shujujiegou.Tree;

import java.util.*;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();
        Tree tree1 = new Tree(1);
        Tree tree2 = new Tree(2);
        Tree tree3 = new Tree(3);
        Tree tree4 = new Tree(4);
        b.setNode(tree1);
        tree1.setLeft(tree2);
        tree1.setRight(tree3);
        tree2.setLeft(tree4);
//        b.printPer();
//        System.out.println("***************************************");
//        b.printMid();
//        System.out.println("***************************************");
//        b.printPost();
//        System.out.println("***************************************");
        System.out.println("*************************层序遍历******************************");
        cengXu2(tree1);


    }

    public static void cengXu(Tree root) {
        if (root == null) {
            System.out.println("二叉树为空！！");
        }
        Tree temp = null;
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
            System.out.println(temp.getId());
        }
    }

    public static void cengXu2(Tree root) {
        if (root == null) {
            System.out.println("二叉树为空！！");
        }
        List<Tree> list = new ArrayList<>();
        list.add(root);
        int i = 0;
        while (i < list.size()) {
            if (list.get(i) == null) {
                i ++;
                continue;
            }
            list.add(list.get(i).getLeft());
            list.add(list.get(i).getRight());
            i++;
        }
        System.out.println(list);
    }
}

class Tree {
    private int id;
    private Tree left;
    private Tree right;

    public Tree(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "node :" + id;
    }

    public void preOrder() {   //前序遍历
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void midOrder() {   //中序遍历
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    public void postOrder() {   //后序遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

}


class BinaryTree {
    private Tree node;

    public void setNode(Tree node) {
        this.node = node;
    }

    public Tree getNode() {
        return node;
    }

    public void printPer() {
        if (node != null) {
            node.preOrder();
        } else {
            System.out.println("二叉树为空！！！");
        }
    }

    public void printMid() {
        if (node != null) {
            node.midOrder();
        } else {
            System.out.println("二叉树为空！！！");
        }
    }

    public void printPost() {
        if (node != null) {
            node.postOrder();
        } else {
            System.out.println("二叉树为空！！！");
        }
    }
}
