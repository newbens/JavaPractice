package com.niuben;

public class Sub2 {
    public static void main(String[] args) {
        getPrime(100, 200);
    }

    public static void getPrime(int a, int b) {
        int sum = 0;
        if (a > b) {
            System.out.println("输入错误");
        }
        System.out.print("素数有：");
        for (int i = a; i <= b; i++) {
            if (isPrime(i)) {
                sum += 1;
                System.out.print(i + " ");
            }
        }
        System.out.println("");
        System.out.printf("一共有素数:%d个",sum);
    }

    private static boolean isPrime(int i) {
        boolean flag = true;
        for (int j = 2; j < i / 2; j++) {
            if (i % j == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
