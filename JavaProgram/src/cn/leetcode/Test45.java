package cn.leetcode;
//��Ծ��Ϸ
public class Test45 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1,4};
        int step = 0;
        int bound = 0;
        int temp = 0;
        for (int i = 0; i <nums.length-1 ; i++) {
            temp = Math.max(temp, nums[i] + i);  //�ҵ�ÿ����Ծ���ܵ�������߽�ֵ��
            if (bound == i) {  //�趨�߽磬�������߽�step��Ҫ��һ��
                step++;
                bound = temp;
            }

        }
        System.out.println(step);
    }
}
