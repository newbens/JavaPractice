package cn.niuben.factory;

import cn.niuben.service.AccountService;
import cn.niuben.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Beanfactory {
    private AccountService accountService;

    private TransactionManager tm;
    public void setTm(TransactionManager tm) {
        this.tm = tm;
    }

    public final void  setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }
    //获取accountService的代理对象
    public AccountService getAccountService() {
        AccountService res = (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    Object res = null;
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        try {
                            //1.开启事务
                            tm.begin();
                            res = method.invoke(accountService, args);
                            //2.提交事务
                            tm.commit();
                        }catch (Exception e){
                            tm.rollback();
                        }finally {
                            tm.release();
                        }
                        return res;
                    }
                });
        System.out.println(res);
        return res;
    }
}
