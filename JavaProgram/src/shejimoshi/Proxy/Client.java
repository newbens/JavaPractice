package shejimoshi.Proxy;

public class Client {
    public static void main(String[] args) {
        ITeacherDao target = new TeacherDao();
        ITeacherDao teacher =  (ITeacherDao)new ProxyFactory(target).getProxyInstance();

    }
}
