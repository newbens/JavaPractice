package shejimoshi.观察者;

public class Client {

   public static void main(String[] args){
       //注册中心
       WeatherData w = new WeatherData();
       //观察者
       Observer observer1 = new CurrentConditions("qq天气");
       Observer observer2 = new CurrentConditions("微信天气");
       //注册
       w.register(observer1);
       w.register(observer2);
       w.setWeather(32.0f,1000.0f,23.4f);

   }

}
