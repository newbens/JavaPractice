package cn.leetcode.offer;

//��ʹ��+-*/ ʵ�� +��
public class Test65 {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int slove = new Test65().slove(a, b);
        System.out.println(slove);
    }

    public int slove(int a, int b) {
        while (b != 0) { // ����λΪ 0 ʱ����
            int c = (a & b) << 1;  // c = ��λ
            a ^= b; // a = �ǽ�λ��
            b = c; // b = ��λ
        }
        return a;

    }
}
