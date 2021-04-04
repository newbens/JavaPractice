package cn.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Test560 {
        public static void main(String[] args) {
            int[] nums = {1, 1, 1};
            int k = 2;
            int i = slove2(nums, k);
            System.out.println(i);
        }

    public static int slove(int[] nums,int k) {
        int res = 0;
        for(int i = 0;i < nums.length;i ++){
            int temp = k - nums[i];
            for(int j = i+1;j < nums.length;j ++){
                temp -= nums[j];
                if(temp == 0){
                    res += 1;
                }
            }
        }
        return res;
    }

    public static int slove2(int[] nums,int k) {
                // key：前缀和，value：key 对应的前缀和的个数
                Map<Integer, Integer> preSumFreq = new HashMap<>();
                // 对于下标为 0 的元素，前缀和为 0，个数为 1
                preSumFreq.put(0, 1);
                int preSum = 0;
                int count = 0;
                for (int num : nums) {
                    preSum += num;
                    // 先获得前缀和为 preSum - k 的个数，加到计数变量里
                    if (preSumFreq.containsKey(preSum - k)) {
                        count += preSumFreq.get(preSum - k);
                    }
                    // 然后维护 preSumFreq 的定义
                    preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
                }
                return count;
            }
        }




