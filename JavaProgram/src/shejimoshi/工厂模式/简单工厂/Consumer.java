package shejimoshi.工厂模式.简单工厂;

public class Consumer {
    public static void main(String[] args){
        CarFactory.getCar("宝马").name();
        CarFactory.getCar("大众").name();
        CarFactory.getCar("特斯拉").name();
    }
}
