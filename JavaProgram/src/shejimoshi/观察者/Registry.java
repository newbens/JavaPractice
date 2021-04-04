package shejimoshi.观察者;
//注册中心接口
public interface Registry {
    void register(Observer observer);
    void remove(Observer observer);
    void notice();
}
