package cn.leetcode;

import java.util.*;

/**
 * 三数之和
 */
public class Test15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> slove = slove(nums);
        System.out.println(slove);
    }

    public static List<List<Integer>> slove(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) break;//如果大于零直接退出
            if (i>0 && nums[i] == nums[i - 1]) continue;
            int x = i + 1;
            int y = len - 1;
            while (x < y) {
                int sum = nums[i] + nums[x] + nums[y];
                if (sum > 0) {
                    while (x < y && nums[y] == nums[y - 1]) {
                        y --;
                    }
                    y --;
                } else if (sum < 0) {
                    while (x < y && nums[x] == nums[x + 1]) {
                        x ++;
                    }
                    x ++;
                }else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[x], nums[y])));
                    while (x < y && nums[x] == nums[x + 1]) {
                        x ++;
                    }
                    x ++;
                    while (x < y && nums[y] == nums[y - 1]) {
                        y -- ;
                    }
                    y --;
                }
            }
        }
        return res;
    }
}
