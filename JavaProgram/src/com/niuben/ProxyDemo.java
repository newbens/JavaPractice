package com.niuben;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//动态代理类
public class ProxyDemo implements InvocationHandler {
    Object object;  //被代理的对象

    public ProxyDemo(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+"开始执行！");
        Object result = method.invoke(this.object);
        System.out.println(method.getName()+"执行完毕！");
        return null;
    }
}