package HuaWei;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HuaWei01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new LinkedList<>();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) break;
            list.add(n);
        }

        for (Integer integer : list) {
            slove(integer,0);
        }
    }

    public static void slove(int n,int sum) {
        if(n < 3){
            if(n == 2) {
                sum++;
            }
            System.out.println(sum);
            return;
        }
        int x = n /3;
        sum += x;
        slove(n/3 + n%3,sum);
    }
}
