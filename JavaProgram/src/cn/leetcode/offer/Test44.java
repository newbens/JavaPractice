package cn.leetcode.offer;
// ����������ĳһλ������
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
        long num = start + (n - 1) / digit; // ͨ��/���� �ҵ����������֡�
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // �ҵ����������ֵĵڼ�λ��
    }
}
