package shujujiegou.Tree;

public class TreeSearch {
    int count = 0;
    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();
        Tree root = new Tree(0);
        Tree tree1 = new Tree(1);
        Tree tree2 = new Tree(2);
        Tree tree3 = new Tree(3);
        b.setNode(root);
        root.setLeft(tree1);
        root.setRight(tree2);
        tree2.setRight(tree3);
        Tree res1 = new TreeSearch().preSearch(1, b.getNode());
        System.out.println(res1);
        Tree res2 = new TreeSearch().midSearch(1, b.getNode());
        System.out.println(res2);
        Tree res3 = new TreeSearch().postSearch(1, b.getNode());
        System.out.println(res3);
    }

    public Tree preSearch(int id,Tree b) {
        count++;
        if (b.getId() == id) {
            System.out.println("所用查找次数："+count);
            System.out.println("查找结果：");
            return b;
        }
        Tree res = null;
        if (b.getLeft() != null) {
            res = preSearch(id, b.getLeft());
        }
        if (res != null) {
            return res;
        }
        if (b.getRight() != null) {
            res = preSearch(id, b.getRight());
        }
        return res;
    }

    public Tree midSearch(int id,Tree b) {
        Tree res = null;
        if (b.getLeft() != null) {
            res = midSearch(id, b.getLeft());
        }
        if (res != null) {
            return res;
        }
        count ++;
        if (b.getId() == id) {
            System.out.println("所用查找次数："+count);
            System.out.println("查找结果：");
            return b;
        }
        if (b.getRight() != null) {
            res = midSearch(id, b.getRight());
        }
        return res;
    }

    public Tree postSearch(int id,Tree b) {
        Tree res = null;
        if (b.getLeft() != null) {
            res = postSearch(id, b.getLeft());
        }
        if (res != null) {
            return res;
        }
        if (b.getRight() != null) {
            res = postSearch(id, b.getRight());
        }if (res != null) {
            return res;
        }
        count ++;
        if (b.getId() == id) {
            System.out.println("所用查找次数："+count);
            System.out.println("查找结果：");
            return b;
        }
        return res;
    }
}
