package Singleton;

/**
 * ��̬����� ��ʽʵ��
 */
public class SingleTon3 {
    public static final SingleTon3 INSTANCE ;
    static {
        INSTANCE = new SingleTon3();
    }
    private SingleTon3() {
    }
}
