package cn.leetcode;

//»ØÎÄ×Ö·û´®
public class Test680 {
    public static void main(String[] args) {
        String s = "ebcbbececabbacecbbcbe";
        boolean res = solve(s);
        System.out.println(res);
    }

    public static boolean solve(String s) {
        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return help(s, left + 1, right) || help(s, left, right - 1);
            }else {
                left++;
                right--;
            }
        }
    return true;

    }

    public static boolean help(String s, int l,int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }else {
                l ++;
                r --;
            }
        }
        return true;
    }
}
