package cn.leetcode;

import java.util.Arrays;

/**
 * ���Ʊ�۲�������dp
 *
 */
public class Test983 {
    public static void main(String[] args) {
        int[] days = {6,8,9,18,20,21,23,25};
        int[] costs = {2, 10, 41};//�ֱ���Ч��1��7��30
        int res = new Test983().mini(days, costs);
        System.out.println(res);
    }

    public int mini(int[] days,int[] costs) {
        int[] dp = new int[days[days.length-1]+31]; //��dp�������31����dp[i+30]��ʱ���ָ��
        int d = days.length-1;  //����ָ������
        for (int i = days[d];i > 0 ; i--) {
            if (days[d] == i) {  //���������ָ�����������м���
                dp[i] = Math.min(costs[0]+dp[i+1], costs[1] + dp[i + 7]);
                dp[i] = Math.min(dp[i],costs[2] + dp[i + 30]);
                d--;  //ָ��ǰ��
            }else {
                dp[i] = dp[i + 1];  //���û�е���ָ�������������У�����ǰһ����ͬ��
            }
            if(d < 0){  //���dС��0˵�������������Ѿ�������ɣ��˳�
                break;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[days[0]];
    }
}
