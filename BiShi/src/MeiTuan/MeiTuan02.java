package MeiTuan;

import java.util.Scanner;

public class MeiTuan02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        int res = 0 ;
        for (int i = 0; i < n; i++) {
            for (int j = i+1 ; j <= n ; j++) {
                if (check(s.substring(i, j)))res++;
            }
        }
        System.out.println(res);
    }

    public static boolean check(String s) {
        StringBuilder newS = new StringBuilder(s);
        return s.equals(newS.reverse().toString());
    }


}
