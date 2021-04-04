package shejimoshi.Factory.abstract1;

public class XiaoMiFactory implements ProductFactory {
    @Override
    public PhoneProduct phoneProduct() {
        return new XiaoMiPhone();
    }

    @Override
    public RouteProduct routeProduct() {
        return new XiaoMiRoute();
    }
}
