package shejimoshi.Factory.abstract1;

public class XiaoMiPhone implements PhoneProduct {
    @Override
    public void start() {
        System.out.println("С�׿���");
    }

    @Override
    public void shutdown() {
        System.out.println("С�׹ػ�");
    }

    @Override
    public void call() {
        System.out.println("С�״�绰");
    }

    @Override
    public void sendSMS() {
        System.out.println("С�׷�����");
    }
}
