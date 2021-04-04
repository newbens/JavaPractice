package daili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test2 {
    public static void main(String[] args) {
        InterTest test = new Test();
//        test.test1();
//        test.test2();

        InvocationHandler hand = new ProxyDemo(test);
        InterTest i = (InterTest) Proxy.newProxyInstance(hand.getClass().getClassLoader(), test.getClass().getInterfaces(), hand);
        //三个参数分别是：1.代理对象的类加载器。2.被代理对象的接口。3代理对象
        i.test1();
        i.test2();
    }
}
