package com.niuben;

public class Test {
    public static void main(String[] args) {
        /*Lhan e1 = Lhan.getIns();
        Lhan e2 = Lhan.getIns();
        Lhan e3 = Lhan.getIns();
        Lhan e4 = Lhan.getIns();
        Lhan e5 = Lhan.getIns();
        System.out.println(e1.toString());
        System.out.println(e2.toString());
        System.out.println(e3.toString());
        System.out.println(e4.toString());
        System.out.println(e5.toString());
        输出为：
         com.leetcode.Ehan@4554617c
        com.leetcode.Ehan@4554617c
        com.leetcode.Ehan@4554617c
        com.leetcode.Ehan@4554617c
        com.leetcode.Ehan@4554617c*/


        /*new CodeBLock();
        new CodeBLock();
        测试结果：
        执行的是静态代码块！！！！！  静态代码块只执行一次而且先执行，然后按顺序执行非静态代码块，然后执行构造函数
        执行的是非静态代码块！！！！
        执行的是非静态代码块2！！！！
        执行的是构造函数！
        执行的是非静态代码块！！！！
        执行的是非静态代码块2！！！！
        执行的是构造函数！
         */

        /*Employee类测试：
            CommonEmployee c = new CommonEmployee();
            c.work();
            c.setInfo("张三", 9527, 5000.6);
            c.getInfo();
            Manager m = new Manager();
            m.work();
            m.setInfo("牛犇", 2424, 2999.9, 5000);
            m.getInfo();
        结果：
            这是一个普通员工！！！
            张三 9527 5000.6
            这是一个管理人员！！！
            牛犇 2424 2999.9 5000.0
            */


        /*  Person1抽象类和接测试：
                Scteacher sct = new Scteacher();
                sct.setInfo("葛天",28,true,"高数");
                sct.showInfo();
                sct.fry();
                sct.sing();
           结果：
                葛天
                28
                true
                高数
                葛天老师拿手的菜是炒菜。
                葛天拿手的歌是夜的第七章。*/


        /* 工厂模式测试：
            SendFactory s = new SendFactory();
            Send send = s.produce("sms");
            send.send();
            Send send2 = s.produce("mail");
            send2.send();
           结果：
                    this is smssender
                    this   is maisender


         */


    }
}
