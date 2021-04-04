package com.niuben;

public class Lhan {
    private Lhan() {   //单例设计-懒 汉式
    }

    private static Lhan lhan = null;

    public static Lhan getIns() {
        if (lhan == null) {
            lhan = new Lhan();
        }
        return lhan;
    }
}
