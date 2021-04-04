package Wangyi;

import java.text.DecimalFormat;
import java.util.Scanner;

public class WangYi11 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat(".00");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        double count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) count++;
        }
        System.out.println(df.format(s.length()/count));
    }
}