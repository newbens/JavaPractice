package shejimoshi.Factory.abstract1;

public class HuaWeiPhone implements PhoneProduct {
    @Override
    public void start() {
        System.out.println("��Ϊ����");
    }

    @Override
    public void shutdown() {
        System.out.println("��Ϊ�ػ�");
    }

    @Override
    public void call() {
        System.out.println("��Ϊ��绰");
    }

    @Override
    public void sendSMS() {
        System.out.println("��Ϊ������");
    }
}
