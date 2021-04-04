package cn.leetcode;

public class Test405 {
    public static void main(String[] args) {
        int a = -26;
        String res = new Test405().slove(a);
        System.out.println(res);
    }

    public String slove(int a) {
        if(a == 0)return 0+"";
        char[] chars = "0123456789abcdef".toCharArray();
        StringBuilder s = new StringBuilder();
        while (a != 0) {
            int temp = a & 15;
            s.append(chars[temp]);
            a = a >>> 4;
        }
        return s.reverse().toString();
    }
}
