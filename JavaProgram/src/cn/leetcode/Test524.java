package cn.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test524 {
    public static void main(String[] args) {
        String s = "abpcplea";
        String[] ss = {"ale", "apple", "monkey", "plea"};
        String res = new Test524().slove(s, ss);
        System.out.println(res);
    }

    public String slove(String s,String[] ss) {
        List<StringNode> list = new ArrayList<>();
        for (int i = 0; i < ss.length; i++) {
            list.add(new StringNode(ss[i],i));
        }
        List<StringNode> newList = compare(list);
        for (StringNode sn : newList) {
            if(isSub(s, sn.s)) return sn.s;
        }
        return "";
    }

    public List<StringNode> compare(List<StringNode> list) {
        Collections.sort(list, new Comparator<StringNode>() {
            @Override
            public int compare(StringNode o1, StringNode o2) {
                if (o1.s.length() != o2.s.length()) {
                    return o2.s.length() - o1.s.length();
                }
                return o1.index - o2.index;
            }
        });
        return list;
    }

    public boolean isSub(String s,String d) {
        int j = 0;
        for (int i = 0; i < s.length() & j < d.length() ; i++) {
            if (s.charAt(i) == d.charAt(j)) {
                j++;
            }
        }
        return j == d.length();
    }
}

class StringNode{
    public String s;
    public int index;

    public StringNode(String s, int index) {
        this.s = s;
        this.index = index;
    }

    @Override
    public String toString() {
        return "StringNode{" +
                "s='" + s + '\'' +
                ", index=" + index +
                '}';
    }
}