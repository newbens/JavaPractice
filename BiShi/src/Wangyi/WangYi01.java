package Wangyi;

import java.text.DecimalFormat;
import java.util.Scanner;

public class WangYi01 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.000000");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //总人数
        int[] s = new int[n];
        for (int i = 0; i < n ; i++) {
            s[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        for (int i = 0; i < sum; i++) {
            int index = sc.nextInt();
            int count = 0;
            for (int j = 0; j < n ; j++) {
                if(s[j] <= s[index-1]) count++;
            }
            System.out.println(df.format((double) count/n*100));
        }

    }
}
