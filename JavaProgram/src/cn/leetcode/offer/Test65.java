package cn.leetcode.offer;

//不使用+-*/ 实现 +法
public class Test65 {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int slove = new Test65().slove(a, b);
        System.out.println(slove);
    }

    public int slove(int a, int b) {
        while (b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;

    }
}
