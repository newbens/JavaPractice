package shejimoshi.工厂模式.工厂方法;

/*
    缺点：

 */
public class CarFactory {
    public static Car getBaoMa() {
        return new BaoMa();
    }
    public static Car getDaZhong() {
        return new DaZhong();
    }
}
