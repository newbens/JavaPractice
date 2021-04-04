package MeiTuan;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class MeiTuan2021_5 {
    static int money;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> q = new LinkedList<>();
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < n ; i++) {
            int num = sc.nextInt();
            q.addLast(num);
        }
        int step = 0;
        while (!q.isEmpty()) {
            for (int i = 0; i < q.size() ; i++) {
                int min1 = getMin(q);
                Integer integer = q.removeFirst();
                if(integer == min1) {
                    step ++;
                    continue;
                }
                else {
                    q.addLast(integer);
                    step ++ ;
                }
            }
        }
        System.out.println(step);
    }

    public static int getMin(LinkedList<Integer> q) {
        int min = Integer.MAX_VALUE;
        for (Integer integer : q) {
            min = Math.min(min, integer);
        }
        return min;
    }

}
