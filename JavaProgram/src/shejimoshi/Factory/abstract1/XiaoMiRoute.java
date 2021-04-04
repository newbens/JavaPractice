package shejimoshi.Factory.abstract1;

public class XiaoMiRoute implements RouteProduct {
    @Override
    public void start() {
        System.out.println("启动小米路由器");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭小米路由器");
    }

    @Override
    public void connectNet() {
        System.out.println("小米路由器连接网络");
    }

    @Override
    public void settingCfg() {
        System.out.println("设置小米路由器");
    }
}
