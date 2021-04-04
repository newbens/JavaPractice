package com.niuben;

public class Ehan {     //单例设计-饿汉式
    private Ehan() {
    }

    private static Ehan ehan = new Ehan();

    public static Ehan getIns() {
        return ehan;
    }
}