package shejimoshi.Factory.abstract1;

public class XiaoMiRoute implements RouteProduct {
    @Override
    public void start() {
        System.out.println("����С��·����");
    }

    @Override
    public void shutdown() {
        System.out.println("�ر�С��·����");
    }

    @Override
    public void connectNet() {
        System.out.println("С��·������������");
    }

    @Override
    public void settingCfg() {
        System.out.println("����С��·����");
    }
}
