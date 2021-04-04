package daili;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
//动态代理
public class ProxyDemo implements InvocationHandler {
    Object object;  //被代理的对象

    public ProxyDemo(Object object) {
        this.object = object;
    }

    @Override

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+"begin");
        Object object = method.invoke(this.object);//执行指定的方法
        System.out.println(method.getName()+"over");

        return object;
    }
}
