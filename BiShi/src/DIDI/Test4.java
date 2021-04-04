package DIDI;


import java.util.LinkedList;
import java.util.Scanner;


public class Test4 {

    public static void main(String[] args) {

        //输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        while (n >0) {
            res += n / 5;
            n /= 5;
        }
        System.out.println(res);
    }
}
