package Singleton;

/**
 * 饿汉式第一种写法    直接
 */
public class SingleTon1 {
    public static final SingleTon1 INSTANCE = new SingleTon1();
    private SingleTon1() {
    }
}
