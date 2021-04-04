package shejimoshi.Factory.abstract1;

public class XiaoMiPhone implements PhoneProduct {
    @Override
    public void start() {
        System.out.println("小米卡机");
    }

    @Override
    public void shutdown() {
        System.out.println("小米关机");
    }

    @Override
    public void call() {
        System.out.println("小米打电话");
    }

    @Override
    public void sendSMS() {
        System.out.println("小米发短信");
    }
}
