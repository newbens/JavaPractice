package cn;

import org.junit.Test;

import java.util.Scanner;

public class Testt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        slove(n,m);
    }

    public static void slove(int n,int m) {
        int count = 0;
        for (int i = n; i <= m ; i++) {
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                String newS =  s.substring(0, j) + s.substring(j + 1, s.length());
                if(newS.charAt(0) == '0') continue;
                Integer integer = Integer.valueOf(newS);
                if(integer == 1) continue;
                if (check(integer)){
                    System.out.println(s);
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }

    public static boolean check(int num){
        boolean a = true;
        for (int i = 2; i < num/2; i++) {
            if(num % 2 == 0) a = false;
        }
        String oldStr = String.valueOf(num);
        String newStr = new StringBuilder(oldStr).reverse().toString();
        return oldStr.equals(newStr) && a;
    }

    @Test
    public void tesg() {
        String s = "103";
        String a = s.substring(0, 0) + s.substring(1, 3);
        System.out.println(Integer.valueOf(a));
    }

}
