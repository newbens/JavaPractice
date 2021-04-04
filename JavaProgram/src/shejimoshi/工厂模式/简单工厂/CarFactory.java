package shejimoshi.工厂模式.简单工厂;
/*
    缺点：
        没有遵守开闭原则，如果有新的车辆，需要改变车工厂类，如果输入车辆名称工厂类没有会输出空，
        用户体验不好。改进方法：将创建车的功能变成每一个方法。
 */
public class CarFactory {
    public static Car getCar(String name) {
        if (name.equals("宝马")) {
            return new BaoMa();
        } else if (name.equals("大众")) {
            return new DaZhong();
        } else return null;
    }
}
