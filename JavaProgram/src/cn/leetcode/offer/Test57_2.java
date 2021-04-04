package cn.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

//和为s的连续正数序列
public class Test57_2 {
    public static void main(String[] args) {
        int target = 9;
        List<List<Integer>> slove = slove(9);
        System.out.println(slove);
    }

    public static List<List<Integer>> slove(int target) {
        int i = 1;//滑动窗口 左边界
        int j = 1;//滑动窗口 右边界
        int sum = 1;//和
        List<List<Integer>> res = new ArrayList<>();
        while (i <= target / 2) {
            //如果sum小于target，滑动窗口右边界扩大
            if (sum < target) {
                j ++;
                sum += j;
                //如果sum小于target，滑动窗口右边界扩大
            } else if (sum > target) {
                sum -= i;
                i ++;
            }else {
                List<Integer> temp = new ArrayList<>();
                for (int k = i; k <= j ; k++) {
                    temp.add(k);
                }
                res.add(temp);
                //添加之后，窗口右移
                sum -= i;
                i ++;
            }
        }
        return res;
    }
}
