package shejimoshi.Factory.abstract1;

public class HuaWeiRoute implements RouteProduct {
    @Override
    public void start() {
        System.out.println("������Ϊ·����");
    }

    @Override
    public void shutdown() {
        System.out.println("�رջ�Ϊ·����");
    }

    @Override
    public void connectNet() {
        System.out.println("��Ϊ·������������");
    }

    @Override
    public void settingCfg() {
        System.out.println("���û�Ϊ·����");
    }
}
