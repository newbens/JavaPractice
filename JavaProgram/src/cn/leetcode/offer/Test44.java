package cn.leetcode.offer;
// 数字序列中某一位的数字
public class Test44 {
    public static void main(String[] args) {
        int slove = new Test44().slove(1000000000);
        System.out.println(slove);
    }

    public int slove(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 通过/运算 找到所属的数字。
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 找到是所属数字的第几位。
    }
}
