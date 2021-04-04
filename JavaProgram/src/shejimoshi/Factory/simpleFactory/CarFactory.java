package shejimoshi.Factory.simpleFactory;

public class CarFactory {
    public static Car getCar(String car) {
        if (car.equals("������")) {
            return new WuLing();
        } else if (car.equals("��˹��")) {
            return new Tesla();
        }else {
            return null;
        }
    }
}
