package Singleton;


/**
 * ���þ�̬�ڲ���ķ�ʽ ����ʵ���̰߳�ȫ����Ϊ�������ֻ�����һ�Ρ�
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
