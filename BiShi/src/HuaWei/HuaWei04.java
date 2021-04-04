package HuaWei;

import java.util.Scanner;

public class HuaWei04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] stus = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                stus[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                String s = sc.next();
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (s.equals("Q")) {
                    int max = 0;
                    for (int j = Math.min(a,b); j <= Math.max(a,b); j++) {
                        max = Math.max(max, stus[j]);
                    }
                    System.out.println(max);
                } else {
                    stus[a] = b;
                }
            }
        } while (sc.hasNext());
        sc.close();
    }
}
