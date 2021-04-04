package cn;


import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

//划分字母区间
public class Test763 {
    @Test
    public void slove() {
        String s = "ababcbacadefegdehijhklij";
        int[] letter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letter[s.charAt(i)-'a'] = i;
        }
//  [8, 5, 7, 14, 15, 11, 13, 19, 22, 23, 20, 21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        List<Integer> list = new LinkedList<>();
        int index = 0,start = 0;
        for (int i = 0; i < s.length() ; i++) {
            index = Math.max(index,letter[s.charAt(i)-'a']);
            if (i == index) {
                list.add(i-start+1);
                start = i + 1;
            }
        }
        System.out.println(list);
    }
}
