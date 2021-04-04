package com.niuben;

import java.util.Scanner;

public class Sub8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("：");
        input.useDelimiter("\n");   //可以检测空白不会直接退出！！！
        String a = input.next();    //遇到空白就退出！！！
        char[] list = a.toCharArray(); //字符串转换成字符串数组！！！
        getNum(list);
    }

    public static void getNum(char[] list) {
        int num1 = 0;  //字母
        String num1Str = "";
        int num2 = 0;  //数字
        String num2Str = "";
        int space = 0; //空格
        String spaceStr = "";
        int other = 0; //其他
        String otherStr = "";
        for (int i = 0; i < list.length; i++) {
            int ascii = (int) list[i];
            if (48 <= ascii && ascii <= 59) {
                num2 = num2 + 1;
                num2Str = num2Str + list[i] + " ";
            } else if (ascii == 32) {
                space = space + 1;
            } else if ((65 <= ascii && ascii <= 90) || (97 <= ascii && ascii <= 122)) {
                num1 = num1 + 1;
                num1Str = num1Str + list[i] + " ";
            } else {
                other = other + 1;
                otherStr = otherStr + list[i] + " ";
            }
        }
        System.out.println("存在字母个数:" + num1);
        System.out.println("存在字母如下:" + num1Str);
        System.out.println("存在数字个数:" + num2);
        System.out.println("存在数字如下:" + num2Str);
        System.out.println("存在空格个数:" + space);
        System.out.println("存在其他个数:" + other);
        System.out.println("存在其他如下:" + otherStr);
    }
}



