package cn.leetcode;

import java.util.Arrays;

/**
 * ����һ���ַ��� s �����㷵��������������������ַ����ĳ��ȣ�ÿ��Ԫ����ĸ��
 * �� 'a'��'e'��'i'��'o'��'u' �������ַ����ж�ǡ�ó�����ż����
 */
public class Test1371 {
    public static void main(String[] args) {
        String s = "eleetminicoworoep";
        solve(s);
    }

    public static void solve(String s) {
        String[] str = s.split("");
        int[] list = new int[str.length];
        System.out.println(Arrays.toString(str));
        for (int i = 0; i < str.length ; i++) {
            if ("a".equals(str[i])) {
                list[i] = 1;
            }else if("e".equals(str[i])){
                list[i] = 2;
            }else if("i".equals(str[i])){
                list[i] = 3;
            }else if("o".equals(str[i])){
                list[i] = 4;
            }else if("u".equals(str[i])){
                list[i] = 5;
            }else {
                list[i] = 0;
            }
        }
        System.out.println(Arrays.toString(list));
    }

}
