package shujujiegou.AvlTree;

public class Avl {
    public static void main(String[] args) {
        int[] a = {10,12,8,9,7,6};
        AvlTree at = new AvlTree();
        for (int i = 0; i <a.length ; i++) {
            Node node = new Node(a[i]);
            at.add(node);
        }
        at.head.print();
        int left = at.head.leftHigh();
        int right = at.head.rightHigh();
        System.out.println("Root:"+at.head.val);
        System.out.println("左子树高："+left+"   "+"右子树高："+right);
        if (right - left > 1) {
            at.head.leftRotate();
            System.out.println("Left Rotate ");
        }
        if (left - right > 1) {
            at.head.rightRotate();
            System.out.println("Right Rotate :");

        }
        int left1 = at.head.leftHigh();
        int right1 = at.head.rightHigh();
        at.head.print();
        System.out.println("Root:"+at.head.val);
        System.out.println("左子树高："+left1+"   "+"右子树高："+right1);
    }
}

class AvlTree{
    Node head = null;

    public void add(Node node) {
        if (head == null) {
            head = node;
        }else {
            head.add(node);
        }

    }

}
class Node{
    Node left;
    Node right;
    int val;

    public Node(int val) {
        this.val = val;
    }

    public int getHigh() {          //获取树高度
        return Math.max(left == null ? 0 : left.getHigh(), right == null ? 0 : right.getHigh()) + 1;
    }

    public int leftHigh() {
        if (this.left == null) {
            return 0;
        }
        return this.left.getHigh();
    }
    public int rightHigh() {
        if (left == null) {
            return 0;
        }
        return right.getHigh();
    }

    //左旋转
    public void leftRotate() {
        Node node = new Node(this.val);
        node.left = this.left;
        node.right = this.right.left;
        this.val = this.right.val;
        this.right = this.right.right;
        this.left = node;
    }

    public void rightRotate() {
        Node node = new Node(this.val);
        node.right = this.right;
        node.left = this.left.right;
        this.val = this.left.val;
        this.right = node;
        this.left = this.left.left;
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.val < this.val) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    public void print() {
        if (this.left != null) {
            this.left.print();
        }
        System.out.print(this.val+" ");
        if (this.right != null) {
            this.right.print();
        }
    }
}