package shujujiegou.Tree;

//线索二叉树
public class ThreadBinaryTree {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        ThreadBtree tb = new ThreadBtree();
        tb.setNode(a);
        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
//        tb.threadBtree(a);
//        TreeNode res = c.getLeft();
//        System.out.println(res.getId());
//        tb.midThreadTree(a);
//        TreeNode res2 = b.getLeft();
//        System.out.println(res2.getId());
        tb.postThreadTree(a);
        TreeNode res3 = b.getRight();
        System.out.println(res3.getId());


    }
}

class ThreadBtree {
    private TreeNode node;
    public TreeNode pre = null;  //指向前驱结点

    public void setNode(TreeNode node) {
        this.node = node;
    }

    public TreeNode getNode() {
        return node;
    }

   //  @param node线索化结点
    public void threadBtree(TreeNode node) {    //中序二叉树线索化
        if (node == null) {
            return;
        }

        threadBtree(node.getLeft());
        if (node.getLeft() == null) {  //当结点没有左孩子，变线索化
            node.setLeft(pre);    //让左指针指向前驱结点
            node.setLefttype(1);  //标志为1
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRighttype(1);
        }

        pre = node;   //每次执行完，把当前结点的值赋给pre，

        threadBtree(node.getRight());
    }

    public void midThreadTree(TreeNode node) {   //前序线索化
        if (node == null) {
            return;
        }
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLefttype(1);
        }

        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRighttype(1);
        }
        pre = node;
        if (node.getLefttype() == 0) {
            midThreadTree(node.getLeft());
        }
        if (node.getRighttype() == 0) {
            midThreadTree(node.getRight());
        }

    }

    public void postThreadTree(TreeNode node) {   //后序线索化
        if (node == null) {
            return;
        }
        postThreadTree(node.getLeft());
        postThreadTree(node.getRight());
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLefttype(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRighttype(1);
        }
        pre = node;

    }

    public void print() {       //中序线索化遍历
        if (node == null) {
            return;
        }
        TreeNode temp = node;
        while (temp != null) {
            while (temp.getLefttype() == 0) {
                temp = temp.getLeft();
            }
            System.out.println(temp.getId());
            while (temp.getRighttype() == 1) {
                temp = temp.getRight();
                System.out.println(temp.getId());
            }
             temp = temp.getRight();
        }
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

class TreeNode {
    private int id;
    private TreeNode left;
    private TreeNode right;
    private int lefttype;   //0表示指向左子树，1表示前驱节点
    private int righttype;

    public TreeNode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getLefttype() {
        return lefttype;
    }

    public void setLefttype(int lefttype) {
        this.lefttype = lefttype;
    }

    public int getRighttype() {
        return righttype;
    }

    public void setRighttype(int righttype) {
        this.righttype = righttype;
    }

    public void preOrder() {   //前序遍历
        System.out.println(this.id);
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
        System.out.println(this.id);
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
        System.out.println(this.id);
    }
}