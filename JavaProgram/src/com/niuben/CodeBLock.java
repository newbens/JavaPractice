package com.niuben;

public class CodeBLock {
    String name;
    static int age;
    public CodeBLock() {
        this.name = "张三";
        System.out.println("执行的是构造函数！");
    }
    //代码块
    {
        System.out.println("执行的是非静态代码块！！！！");
    }
    {
        System.out.println("执行的是非静态代码块2！！！！");
    }
    static {      //只能使用静态属性和静态方法
        age = 1;
        System.out.println("执行的是静态代码块！！！！！");

    }


}
