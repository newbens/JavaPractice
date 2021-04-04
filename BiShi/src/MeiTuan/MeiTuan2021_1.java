package MeiTuan;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MeiTuan2021_1 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.0");
        Scanner sc = new Scanner(System.in);
        int res = 0;
        int count = 0;
        for (int i = 0; i < 5; i++) {
            int n = sc.nextInt();
            count += n;
            res += n * (i + 1);
        }
        if(count == 0) System.out.println("0.0");
        System.out.println(Math.floor(((double) res/count)*10)/10);
    }
}
