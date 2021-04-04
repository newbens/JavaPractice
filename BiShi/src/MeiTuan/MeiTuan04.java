package MeiTuan;//前缀树

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class MeiTuan04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strArr = new String[n];
        HelpTree tree = new HelpTree();
        for (int i = 0; i < n; i++) {
            strArr[i] = sc.next();
            tree.insert(strArr[i]);
        }
        for (String s : strArr)
            System.out.println(tree.findMaxPrefix(s));
    }

    public static class TreeNode{
        public int count ;
        public Map<Character, TreeNode> map;

        public TreeNode() {
            this.count = 0;
            this.map = new HashMap<>();
        }
    }

    public static class HelpTree{

        private TreeNode root;

        public HelpTree() {
            this.root = new TreeNode();
        }

        public  void insert(String word) {
            if(word == null) return;
            char[] cs = word.toCharArray();
            TreeNode node = root;
            for (int i = 0; i < cs.length ; i++) {
                if (!node.map.containsKey(cs[i])) {
                    node.map.put(cs[i], new TreeNode());
                }
                node = node.map.get(cs[i]);
                node.count++;
            }
        }

        public String findMaxPrefix(String word) {
            if(word.isEmpty()) return "";
            TreeNode node = root;
            char[] cs = word.toCharArray();
            String res = "";
            for (int i = 0; i < cs.length ; i++) {
                if (node.map.containsKey(cs[i])) {
                    res += cs[i];
                    node = node.map.get(cs[i]);
                    if(node.count == 1) return res;
                } else return "";
            }
            return res;
        }

    }
}