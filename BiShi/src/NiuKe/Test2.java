package NiuKe;

import java.util.*;

public class Test2 {
    static List<List<String>> res = new ArrayList<>();
    static List<String> pre = new LinkedList<>();
    static List<String> mid = new LinkedList<>();
    static List<String> post = new LinkedList<>();
    static String[] treeNodes = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        treeNodes = s.substring(1, s.length() - 1).split(",");
        pre(0);
        mid(0);
        post(0);
        res.add(pre);
        res.add(mid);
        res.add(post);
        System.out.println(res);

    }

    public static void pre(int index){
        if (treeNodes == null || treeNodes.length == 0) return;
        pre.add(treeNodes[index]);
        if ((2 * index + 1) < treeNodes.length) pre(2*index+1);
        if((2*index+2) < treeNodes.length) pre(2*index+2);
    }
    public static void mid(int index){
        if (treeNodes == null || treeNodes.length == 0) return;
        if ((2 * index + 1) < treeNodes.length) mid(2*index+1);
        mid.add(treeNodes[index]);
        if((2*index+2) < treeNodes.length) mid(2*index+2);
    }
    public static void post(int index){
        if (treeNodes == null || treeNodes.length == 0) return;
        if ((2 * index + 1) < treeNodes.length) post(2*index+1);
        if((2*index+2) < treeNodes.length) post(2*index+2);
        post.add(treeNodes[index]);

    }
}
