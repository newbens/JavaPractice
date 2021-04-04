package Wangyi;

import org.junit.Test;

import java.util.*;

public class WangYi06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int pro = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (target % a[i] == 0) {
                map.put(i, a[i]);
                pro *= a[i];
            }
        }
        System.out.println(pro);
        int res = 0;
        if (pro >= target) {
            int num1 = pro / target;
            for (int i = 0; i < n; i++) {
                if (!map.containsKey(i)) res += a[i] - 1;
            }
            for (Integer integer : map.keySet()) {
                if (map.get(integer) == num1) res += a[integer] - 1;
            }
        } else {
            int add = 0;
            int num2 = target / pro;
            for (int i = 0; i < n; i++) {
                if (map.containsKey(i)) continue;
                else {
                    res += a[i] - 1;
                }
            }
            res = res - (num2 - 1);
        }
        System.out.println(res);
    }
}
