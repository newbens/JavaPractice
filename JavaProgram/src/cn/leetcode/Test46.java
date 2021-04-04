package cn.leetcode;

import java.util.ArrayList;
import java.util.List;

//È«ÅÅÐò
public class Test46 {
    public static void main(String[] args) {
        int[] nums = {1, 2,3};
        List<List<Integer>> res = new ArrayList<>();
        backTrace(nums,res,new ArrayList<Integer>());
        System.out.println(res);
    }

    public static void backTrace(int[] nums,List<List<Integer>> res,ArrayList<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i]))continue;
            temp.add(nums[i]);
            backTrace(nums, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
