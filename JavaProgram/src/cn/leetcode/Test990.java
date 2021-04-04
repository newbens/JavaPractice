package cn.leetcode;

//union-find模板提 并查集
public class Test990 {

    public static void main(String[] args) {
        String[] e = {"a==b","b==a"};
        int[] parent = new int[26];
        //初始化。每个节点的父节点是自己
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        //先将所有相等的等式，设置子父关系
        for (String s : e) {
            if (s.charAt(1) == '!') {
                continue;
            }
            int le = s.charAt(0) - 'a';
            int ri = s.charAt(3) - 'a';
            union(parent,le,ri);
        }
        //查找所有不等式的关系，如果违背相等的子父关系，直接return  false。
        for (String s : e) {
            if (s.charAt(1) == '=') {
                continue;
            }
            int le = s.charAt(0) - 'a';
            int ri = s.charAt(3) - 'a';
            if (find(parent, le) == find(parent, ri)) {
                System.out.println("false");
            }
        }
        System.out.println("....");

    }
    //设置每个的父节点
    public static void union(int[] parent,int i,int j) {
        int i1 = find(parent, i);
        int i2 = find(parent, j);
        parent[i1] = i2;
    }
    //查找每个节点的父节点
    public static int find(int[] parent,int i) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return parent[i];
    }
}

