package cn.leetcode.offer;

import java.util.Arrays;

public class Test29 {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int b = a.length - 1;
        int r = a[0].length - 1;
        int index = 0, t = 0, l = 0;
        int[] res = new int[(b + 1) * (r + 1)];
        while (true) {
            for (int i = l; i <= r; i++) {    //����
                res[index++] = a[t][i];
            }
            if (++t > b) {   //��������  ������һ��
                break;
            }
            for (int i = t; i <= b; i++) {    //�ϵ���
                res[index++] = a[i][r];
            }
            if (--r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {   //�ҵ���
                res[index++] = a[b][i];
            }
            if (--b < t) {
                break;
            }
            for (int i = b; i >= t; i--) {  //�µ���
                res[index++] = a[i][l];
            }
            if (++l > r) {
                break;
            }
        }
        System.out.println(Arrays.toString(res));
    }
}

