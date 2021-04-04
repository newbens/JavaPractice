package shejimoshi.Proxy.Cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {

    private Object object;

    public ProxyFactory(Object object) {
        this.object = object;
    }
    //���ش������
    public Object getProxyInstance() {
        //����������
        Enhancer enhancer = new Enhancer();
        //���ø���
        enhancer.setSuperclass(object.getClass());
        //���ûص�����
        enhancer.setCallback(this);
        //�����������
        return enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("CGlib����ģʽ��ʼ~");
        Object invoke = method.invoke(object,objects);
        System.out.println("�������");
        return invoke;
    }
}
