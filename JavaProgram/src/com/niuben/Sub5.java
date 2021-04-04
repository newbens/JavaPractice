package com.niuben;

import java.util.Scanner;

public class Sub5 {
    public static void main(String[] args) {
        System.out.println("请输入成绩：");
        Scanner input = new Scanner(System.in);
        int score = input.nextInt();
        String result = score >= 90 ? "A" : (60 <= score && score < 90 ? "B" : "C");
        System.out.printf("评分为：%s", result);
    }

    public static class Sub8 {
        public static void main(String[] args) {
            System.out.println("请输入第一个数：");
            Scanner input = new Scanner(System.in);
            int a = input.nextInt();
            System.out.println("请输入第二个数：");
            int b = input.nextInt();
            int gb = getGongbei(a, b);
            int gy = getGongYue(a, b);
            System.out.println("最小公倍数："+gb);
            System.out.println("最大公约数："+gy);
        }

        public static int getGongbei(int a, int b) {
            return a * b / getGongYue(a, b);
        }

        public static int getGongYue(int a, int b) {
         /*   int num = 1;
            for (int i=1; i<=a && i<=b; i++){
                if (a%i==0 && b%i==0){
                    num = i;
                }
            }
            return num;*/
    //        递归
            int big = a>b? a:b;
            int small = a<b? a:b;
            if (big % small == 0) {
                return small;
            }
            return getGongYue(big % small, small);
        }
    }
}
