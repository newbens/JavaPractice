package shujujiegou.SuanFa;

import java.util.Arrays;

public class Kmp {
    public static void main(String[] args) {
        String s1 = "BBC ABCDAB ABCDABCDABDEABCDABDABCD";
        String s2 = "ABCDABDABCD";
//        int res = V(s1, s2);
//        System.out.println(res);
        int res = kmp(s1, s2);
        System.out.println(res);
    }

    public static int V(String s1, String s2) {  //暴力匹配
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int x = s1.length();
        int y = s2.length();
        int i = 0, j = 0;
        while (i < x && j < y) {
            if (c1[i] == c2[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == s2.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static int kmp(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[] help = new int[s2.length()];
        int x = 0, num = 0;
        for (int i = 1,j = 0; i < c2.length ; i++) {
            while (j > 0 && c2[j] != c2[i]) {
                j = help[j - 1];
            }
            if (c2[i] == c2[j]) {
                j ++;
            }
            help[i] = j;
        }
//        for (int i = 1; i < s2.length(); i++) {
//            if (c2[i] == c2[x]) {
//                x++;
//                num++;
//                help[i] = num;
//            } else {
//                help[i] = 0;
//                num = 0;
//            }
//        }
        System.out.println(Arrays.toString(help));
        for (int i = 0, j = 0; i < c1.length; i++) {
            while (j > 0 && c1[i] != c2[j]) {
                j = help[j-1];
                System.out.println(j);
            }
            if (c1[i] == c2[j]) {
                j++;
            }
            if (j == s2.length()) {  //说明找到了字符串
                return i - j + 1;
            }
        }
        return -1;
    }
}
