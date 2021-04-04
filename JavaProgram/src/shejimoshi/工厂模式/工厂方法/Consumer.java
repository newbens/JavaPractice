package shejimoshi.工厂模式.工厂方法;

public class Consumer {
    public static void main(String[] args){
        CarFactory.getBaoMa().name();
        CarFactory.getDaZhong().name();
    }
}
