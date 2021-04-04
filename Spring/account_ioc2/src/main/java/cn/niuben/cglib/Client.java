package cn.niuben.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Repository;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(final String[] args) {
        final Producer p = new Producer();
        Producer producer = (Producer) Enhancer.create(p.getClass(), new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Float money = (Float) objects[0];
                Object res = null;
                if ("saleProduct".equals(method.getName())) {
                    res = method.invoke(p, money * 0.8f);
                }
                return res;
            }
        });
        producer.saleProduct(10000f);
    }
}
