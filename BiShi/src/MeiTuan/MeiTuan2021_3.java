package MeiTuan;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class MeiTuan2021_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Tree tree = new Tree();
        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            tree.insert(u,v,w);
        }

    }

    public static class TreeNode{
        int path = 0;
        Map<Integer, TreeNode> map;

        public TreeNode(int path) {
            this.path = path;
            this.map = new HashMap<>();
        }
    }

    public static class Tree{

        private TreeNode root;

        public Tree() {
            this.root = new TreeNode(0);
        }

        public void insert(Integer u,int v,int w) {
            TreeNode node = root;
            if (u == 1){
                root.map.put(v, new TreeNode(w));
            }else {
                TreeNode treeNode = root.map.get(u);
                treeNode.map.put(v, new TreeNode(w));
            }
        }

    }
}
