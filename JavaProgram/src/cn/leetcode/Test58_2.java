package cn.leetcode;
//×Ö·û´®×óÐý
public class Test58_2 {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String slove = slove(s, k);
        System.out.println(slove);
    }

    public static String slove(String s,int k) {

        return s.substring(k, s.length()) + s.substring(0, k);
    }

}



