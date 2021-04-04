package cn.leetcode.offer;

public class Test33 {
    public static void main(String[] args) {
        int[] a = {1, 3, 2, 6, 5};
        boolean res = new Test33().slove(a);
        System.out.println(res);
    }

    public boolean slove(int[] a) {
        if(a.length == 0) return false;
        return rec(a, 0, a.length - 1);
    }

    public boolean rec(int[] a,int start,int end) {
        if(start >= end)return true;
        int i = start;
        while (a[i] < a[end]) {   //�õ��������±�
            i++;
        }
        int m = i;
        while (a[i] > a[end]) {   //�ж��������Ƿ�С��end
            i++;
        }
        //���i������end��˵�����Ϲ���
        return i == end && rec(a, start, m - 1) && rec(a, m, end-1);  //�ݹ�ѭ��������
    }
}
