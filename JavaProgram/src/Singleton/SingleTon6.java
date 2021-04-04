package Singleton;

/**
 * ����ʽ ˫�˼�� ʵ���̰߳�ȫ
 */
public class SingleTon6 {
    private SingleTon6() {

    }

    private static volatile SingleTon6 instance = null;

    public static SingleTon6 getInstance() {
        if (instance == null) {
            synchronized (SingleTon6.class) {
                if (instance == null) {
                    instance = new SingleTon6();
                }
            }
        }
        return instance;
    }
}
