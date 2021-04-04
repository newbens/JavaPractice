package shejimoshi.Factory.abstract1;

public class HuaWeiFactory implements ProductFactory {
    @Override
    public PhoneProduct phoneProduct() {
        return new HuaWeiPhone();
    }

    @Override
    public RouteProduct routeProduct() {
        return new HuaWeiRoute();
    }
}
