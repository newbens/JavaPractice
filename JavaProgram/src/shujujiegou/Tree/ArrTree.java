package shujujiegou.Tree;

//前中后序遍历二叉树
public class ArrTree {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree ab = new ArrBinaryTree(a);
        ab.pre();
        System.out.println();
        ab.mid();
        System.out.println();
        ab.post();
    }

}


class ArrBinaryTree{
    public int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    //重载
    public void pre() {
        this.pre(0);
    }

    public void mid() {
        this.mid(0);
    }

    public void post() {
        this.post(0);
    }

    public void pre(int index) {
        if (arr == null || arr.length == 0) {
            return;
        }
        System.out.print(arr[index]);
        if ((2 * index + 1) < arr.length) {
            pre(2*index+1);
        }
        if ((2 * index + 2) < arr.length) {
            pre(2*index+2);
        }
    }

    public void mid(int index) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if ((2 * index + 1) < arr.length) {
            mid(2*index+1);
        }
        System.out.print(arr[index]);

        if ((2 * index + 2) < arr.length) {
            mid(2*index+2);
        }
    }

    public void post(int index) {
        if (arr == null || arr.length == 0) {
            return;
        }


        if ((2 * index + 1) < arr.length) {
            post(2*index+1);
        }

        if ((2 * index + 2) < arr.length) {
            post(2*index+2);
        }
        System.out.print(arr[index]);
    }
}
