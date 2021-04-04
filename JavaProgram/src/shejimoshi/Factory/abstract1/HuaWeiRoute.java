package shejimoshi.Factory.abstract1;

public class HuaWeiRoute implements RouteProduct {
    @Override
    public void start() {
        System.out.println("启动华为路由器");
    }

    @Override
    public void shutdown() {
        System.out.println("关闭华为路由器");
    }

    @Override
    public void connectNet() {
        System.out.println("华为路由器连接网络");
    }

    @Override
    public void settingCfg() {
        System.out.println("设置华为路由器");
    }
}
