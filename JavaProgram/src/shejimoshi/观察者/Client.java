package shejimoshi.�۲���;

public class Client {

   public static void main(String[] args){
       //ע������
       WeatherData w = new WeatherData();
       //�۲���
       Observer observer1 = new CurrentConditions("qq����");
       Observer observer2 = new CurrentConditions("΢������");
       //ע��
       w.register(observer1);
       w.register(observer2);
       w.setWeather(32.0f,1000.0f,23.4f);

   }

}
