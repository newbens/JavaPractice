package shejimoshi.观察者;

//实现观察者
public class CurrentConditions implements Observer  {
    private String name;
    private float tem;
    private float pre;
    private float hum;

    public CurrentConditions(String name) {
        this.name = name;
    }

    @Override
    public void update(float tmp, float pre, float hum) {
        this.tem = tmp;
        this.pre = pre;
        this.hum = hum;
        display();
    }

    public void display() {
        System.out.println("----"+name+"----");
        System.out.println("当前温度："+tem);
        System.out.println("当前压力："+pre);
        System.out.println("当前湿度："+hum);
    }
}
