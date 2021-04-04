package shejimoshi.观察者;

import java.util.ArrayList;

//天气注册中心
public class WeatherData implements Registry {
    private float tem;
    private float pre;
    private float hum;
    private ArrayList<Observer> observes;

    public float getTem() {
        return tem;
    }

    public float getPre() {
        return pre;
    }

    public float getHum() {
        return hum;
    }

    public void setWeather(float tem,float pre,float hum) {
        this.tem = tem;
        this.pre = pre;
        this.hum = hum;
        WeatherChange();
    }

    public void WeatherChange() {
        notice();
    }

    public WeatherData() {
        this.observes = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        observes.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observes.remove(observer);
    }

    @Override
    public void notice() {
        for (Observer observe : observes) {
            observe.update(getTem(),getPre(),getHum());
        }
    }
}
