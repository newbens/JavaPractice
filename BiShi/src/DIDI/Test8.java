package DIDI;

import java.util.*;

public class Test8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long x = 1;
        long y = 1;
        LinkedList<Long> list = new LinkedList<>();
        list.add(1l);
        list.add(1l);
        for (int i = 2; i < n * n; i++) {
            long sum = x + y;
            list.add(sum);
            x = y;
            y = sum;
        }
        Long[][] res = new Long[n][n];
        int t = 0, b = n - 1, le = 0, ri = n - 1;
        while (true) {
            for (int i = le; i <= ri; i++) {  //左到右
                res[t][i] = list.removeLast();
            }
            t++;
            if (t > b) break;
            for (int i = t; i <= b; i++) {    //上到下
                res[i][ri] = list.removeLast();
            }
            ri--;
            if (le > ri) break;
            for (int i = ri; i >= le; i--) {    //右到左
                res[b][i] = list.removeLast();
            }
            b--;
            if (t > b) break;
            for (int i = b; i >= t; i--) {     //下到上
                res[i][le] = list.removeLast();
            }
            le++;
            if (le > ri) break;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
}
