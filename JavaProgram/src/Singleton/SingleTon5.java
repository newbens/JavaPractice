package Singleton;


/**
 * 采用静态内部类的方式 乐意实现线程安全，因为类加载器只会加载一次。
 */
public class SingleTon5 {

    private SingleTon5() {
    }

    private static class Inner {
        private static final SingleTon5 INSTANCE = new SingleTon5();
    }

    public static SingleTon5 getInstance() {
        return Inner.INSTANCE;
    }


}
