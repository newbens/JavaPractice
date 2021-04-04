package com.niuben;

public class Sub6 {
        public static void main(String[] args) {
            String a = new String("ab"); // a 为一个引用
            String b = new String("ab"); // b为另一个引用,对象的内容一样
            String aa = "ab";
            String bb = "ab";
            if (aa == bb)
                System.out.println("aa==bb");// true
            if (a == b)
                System.out.println("a==b");// false，非同一对象


    }
}