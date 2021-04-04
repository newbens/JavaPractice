package cn.leetcode.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test04 {
    public static void main(String[] args) {
        int[][] m = {{1, 4, 7, 11, 15},
                    {2, 5, 8, 12, 19},
                    {3, 6, 9, 16, 22},
                    {10, 13, 14, 17, 24},
                    {18, 21, 23, 26, 30}};
        boolean flag = new Test04().getNum(m, 5);
        System.out.println(flag);
    }

    public boolean getNum(int[][] m,int target) {
        Stack stack = new Stack();
        stack.peek();
        List list = new ArrayList();
        int i =m.length -1;
        int j = 0;
        while (i >= 0 && j < m[0].length) {
            if (m[i][j] > target) {
                i --;
            } else if (m[i][j] < target) {
                j++;
            }else {
                return true;
            }
        }
        return false;
    }

}
