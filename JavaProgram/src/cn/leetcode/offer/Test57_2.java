package cn.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

//��Ϊs��������������
public class Test57_2 {
    public static void main(String[] args) {
        int target = 9;
        List<List<Integer>> slove = slove(9);
        System.out.println(slove);
    }

    public static List<List<Integer>> slove(int target) {
        int i = 1;//�������� ��߽�
        int j = 1;//�������� �ұ߽�
        int sum = 1;//��
        List<List<Integer>> res = new ArrayList<>();
        while (i <= target / 2) {
            //���sumС��target�����������ұ߽�����
            if (sum < target) {
                j ++;
                sum += j;
                //���sumС��target�����������ұ߽�����
            } else if (sum > target) {
                sum -= i;
                i ++;
            }else {
                List<Integer> temp = new ArrayList<>();
                for (int k = i; k <= j ; k++) {
                    temp.add(k);
                }
                res.add(temp);
                //���֮�󣬴�������
                sum -= i;
                i ++;
            }
        }
        return res;
    }
}
