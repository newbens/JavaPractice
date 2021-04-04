package shejimoshi.Factory.simpleFactory;

public class CarFactory {
    public static Car getCar(String car) {
        if (car.equals("五菱宏光")) {
            return new WuLing();
        } else if (car.equals("特斯拉")) {
            return new Tesla();
        }else {
            return null;
        }
    }
}
