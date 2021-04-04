package Wangyi;

import java.util.Scanner;

public class WangYi09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String res = "";
        while (n != 0) {
            if (n % 2 == 0) {
                res += "2";
                n = (n-2)/2;
            }else {
                res += "1";
                n = (n-1)/2;
            }
        }
        System.out.println(new StringBuilder(res).reverse());
    }
}
