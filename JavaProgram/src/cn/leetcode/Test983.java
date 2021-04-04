package cn.leetcode;

import java.util.Arrays;

/**
 * 最低票价采用逆向dp
 *
 */
public class Test983 {
    public static void main(String[] args) {
        int[] days = {6,8,9,18,20,21,23,25};
        int[] costs = {2, 10, 41};//分别有效期1，7，30
        int res = new Test983().mini(days, costs);
        System.out.println(res);
    }

    public int mini(int[] days,int[] costs) {
        int[] dp = new int[days[days.length-1]+31]; //给dp数组加上31放置dp[i+30]的时候空指针
        int d = days.length-1;  //用于指向天数
        for (int i = days[d];i > 0 ; i--) {
            if (days[d] == i) {  //如果到达了指定天数，进行计算
                dp[i] = Math.min(costs[0]+dp[i+1], costs[1] + dp[i + 7]);
                dp[i] = Math.min(dp[i],costs[2] + dp[i + 30]);
                d--;  //指针前移
            }else {
                dp[i] = dp[i + 1];  //如果没有到达指定天数，不出行，金额和前一天相同。
            }
            if(d < 0){  //如果d小于0说明，所有天数已经安排完成，退出
                break;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[days[0]];
    }
}
