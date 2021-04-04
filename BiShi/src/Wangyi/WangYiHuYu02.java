package Wangyi;

import java.security.PublicKey;
import java.util.*;

public class WangYiHuYu02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                l.add(sc.nextInt());
            }
            list.add(l);
        }
        solution(list);
    }

    public static void solution(List<List<Integer>> list) {
        if(list.size() == 0)return;
        int n = list.size();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                y[i] += list.get(i).get(j);
                x[i] += list.get(j).get(i);
            }
        }
        int num = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = x[j] + y[i] - list.get(i).get(j);
                if (count > num) {
                    num = count;
                    a = i;
                    b = j;
                }
            }
        }
        list.remove(a);
        for (int i = 0; i < n-1; i++) {
            list.get(i).remove(b);
        }
        System.out.println((a+1)+" "+(b+1));
        solution(list);
    }
}
