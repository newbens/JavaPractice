package Wangyi;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WangYi08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int queryNums = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int money = sc.nextInt();
            if(map.containsKey(money)) {
                Integer integer = map.get(money);
                map.put(money, integer+1);
            }else {
                map.put(money, 1);
            }
        }
        System.out.println(map);
        for (int i = 0; i < queryNums; i++) {
            int index = sc.nextInt();
            if (map.containsKey(index)) {
                System.out.println(map.get(index));
            }else System.out.println(0);
        }
    }



}
