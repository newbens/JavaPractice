package shejimoshi.Factory.abstract1;

public class HuaWeiPhone implements PhoneProduct {
    @Override
    public void start() {
        System.out.println("华为开机");
    }

    @Override
    public void shutdown() {
        System.out.println("华为关机");
    }

    @Override
    public void call() {
        System.out.println("华为打电话");
    }

    @Override
    public void sendSMS() {
        System.out.println("华为发短信");
    }
}
