package cn.leetcode;

import java.util.ArrayList;
import java.util.List;

//优美子数组
public class Test1248 {
    public static void main(String[] args) {
        int[] num = {2,2,2,1,2,2,1,2,2,2};
        int k =2;
        int res = 0;
        //想要提高效率可使用定长数组。
        List<Integer> list=new ArrayList<>();
        list.add(-1);
        for (int i = 0;i<num.length;i++) {
            if (isOdd(num[i])) {
                list.add(i);
            }
        }
        list.add(num.length);
        System.out.println(list);
        for (int i = 1; i + k < list.size(); i++) {
            res += ((list.get(i) - list.get(i - 1)) * (list.get(i + k ) - list.get(i + k - 1)));
        }
        System.out.println(res);
    }

    public static boolean isOdd(int n) {
        if (n % 2 == 1) {
            return true ;
        }else{
            return false;
        }
    }
}
