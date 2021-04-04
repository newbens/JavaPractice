package shejimoshi.Factory.FactoryMethod;

public class Consumer {
    public static void main(String[] args) {
        Car car = new WuLingFactory().getCar();
        Car car1 = new TeslaFactory().getCar();
        car.name();
        car1.name();

    }
}
