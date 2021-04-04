package cn.leetcode.offer;


import java.util.HashMap;
import java.util.Map;

/**
 * ˼·��ǰ���������ȷ�����ڵ㣬Ȼ��ͨ��ǰ������õ��ĸ��ڵ㽫��������ֳ��������������ݹ�ó��𰸡�
 */
public class Test07 {
    int[] pre_temp;
    Map<Integer, Integer> map;  //������Ͷ�Ӧ���±�

    public static void main(String[] args) {
        int[] pre = {3, 9, 2, 15, 7};
        int[] mid = {9, 3, 15, 20, 7};
        Tnode init = new Test07().init(pre, mid);
        System.out.println();
    }

    public Tnode init(int[] pre, int[] mid) {
        pre_temp = pre;
        map = new HashMap<>();
        for (int i = 0; i < mid.length; i++) {
            map.put(mid[i], i);
        }
        Tnode slove = slove(0, mid.length - 1, 0);
        return slove;


    }

    /**
     *
     * @param root_index   ���ڵ�    ǰ���������ĵ�һ�������Ǹ��ڵ�
     * @param right_index  �����ұ߽�
     * @param left_index    ������߽�
     * @return
     */
    public Tnode slove(int root_index, int right_index, int left_index) {
        if (left_index > right_index) {  //�˳��ݹ�����
            return null;
        }
        int index = map.get(pre_temp[root_index]); //�õ����ڵ��Ӧ���±�
        Tnode root = new Tnode(pre_temp[root_index]);
        //��������һ�������������ĸ����
        root.left = slove(root_index + 1, index - 1, 0);
        //�������ĸ��ڵ��±���  ���ڵ��±��������������+1��
        root.right = slove(root_index + (index - 1 - right_index + 1) + 1, right_index, index + 1);
        return root;
    }
}

class Tnode{
    Integer val;
    Tnode left;
    Tnode right;

    public Tnode(Integer val) {
        this.val = val;
    }
}
