package shejimoshi.Factory.simpleFactory;

public class Consumer {
    public static void main(String[] args) {
        Car car1 = CarFactory.getCar("������");
        Car car2 = CarFactory.getCar("��˹��");
        car1.name();
        car2.name();
    }
}
