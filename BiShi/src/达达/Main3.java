package 达达;

import org.junit.Test;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(reslove(num));
    }

    public static int reslove(int num) {
        if(num < 10) return num;
        int bt = 0;
        while (num > 0) {
            bt += (num % 10);
            num /= 10;
        }
        return reslove(bt);
    }

}
