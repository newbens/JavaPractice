package shejimoshi.Factory.abstract1;

public class Test {
    public static void main(String[] args) {
        XiaoMiFactory xiaoMiFactory = new XiaoMiFactory();
        PhoneProduct phoneProduct = xiaoMiFactory.phoneProduct();
        RouteProduct routeProduct = xiaoMiFactory.routeProduct();
        phoneProduct.call();
        routeProduct.start();

    }
}
