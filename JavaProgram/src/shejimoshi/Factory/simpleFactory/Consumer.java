package shejimoshi.Factory.simpleFactory;

public class Consumer {
    public static void main(String[] args) {
        Car car1 = CarFactory.getCar("五菱宏光");
        Car car2 = CarFactory.getCar("特斯拉");
        car1.name();
        car2.name();
    }
}
