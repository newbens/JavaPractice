package Singleton;

/**
 * 静态代码块 方式实现
 */
public class SingleTon3 {
    public static final SingleTon3 INSTANCE ;
    static {
        INSTANCE = new SingleTon3();
    }
    private SingleTon3() {
    }
}
