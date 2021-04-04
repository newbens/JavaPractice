import com.niuben.service.AccountService;
import com.niuben.service.AccountServiceImp;
import com.niuben.utils.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AccountServiceImpTest {
//    @Test
//    public void test1() {
//        final AccountServiceImp a = new AccountServiceImp();
//        AccountService res = (AccountService) Proxy.newProxyInstance(a.getClass().getClassLoader(), a.getClass().getInterfaces(), new InvocationHandler() {
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                Object res = null;
//                Logger l = new Logger();
//                l.printLog();
//                res = method.invoke(a, args);
//                return res;
//            }
//        });
//        res.deleteAccount();
//    }

    @Test
    public void test2() {
        ApplicationContext a = new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = (AccountService) a.getBean("accountService");
        as.saveAccount();

    }

}
