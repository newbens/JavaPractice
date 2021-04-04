package cn.leetcode;

public class Test9 {
    public static void main(String[] args) {
        int i = 121;
        int abs = Math.abs(i);
        String s = String.valueOf(abs);
        char[] list = s.toCharArray();
        int left = 0;
        int right = list.length;
        while (left < right) {
            if (list[left] != list[right]) {
                System.out.println("false");
                break;
            }
            left++;
            right--;
        }

    }
}
