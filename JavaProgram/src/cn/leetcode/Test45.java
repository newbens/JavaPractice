package cn.leetcode;
//跳跃游戏
public class Test45 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1,4};
        int step = 0;
        int bound = 0;
        int temp = 0;
        for (int i = 0; i <nums.length-1 ; i++) {
            temp = Math.max(temp, nums[i] + i);  //找到每次跳跃后能到达的最大边界值。
            if (bound == i) {  //设定边界，如果到达边界step就要加一。
                step++;
                bound = temp;
            }

        }
        System.out.println(step);
    }
}
