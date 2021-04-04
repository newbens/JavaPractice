package com.niuben;

import java.util.Scanner;

public class Sub1{
    public static void main(String[] args) {
        System.out.println("请输入月份：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fun(n));
    }
    public  static  int fun(int n){
        if (n==1 || n ==2)
            return 1;
        else
            return fun(n - 1) + fun(n - 2);


    }


}