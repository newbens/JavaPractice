package shejimoshi.�۲���;

//ʵ�ֹ۲���
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
        System.out.println("��ǰ�¶ȣ�"+tem);
        System.out.println("��ǰѹ����"+pre);
        System.out.println("��ǰʪ�ȣ�"+hum);
    }
}
