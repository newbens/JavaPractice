package com.niuben.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 记录日志
 */
@Component("logger")
@Aspect//表示当前类是一个切面类
public class Logger {
    /**
     * 用于打印日志，在切入点方法之前（切入点方法就是业务层方法）
     */
    @Pointcut("execution(* com.niuben.service.*.*(.. ))")//切入点表达式
    public void p() { }

    @Before("p()")
    public void BeforeprintLog() {
        System.out.println("前置通知");
   }
    @AfterReturning("p()")
    public void afterprintLog() {
        System.out.println("后置通知");
    }
    @AfterThrowing("p()")
    public void exceptionprintLog() {
        System.out.println("异常通知");
    }
    @After("p()")
    public void finallprintLog() {
        System.out.println("最终通知");
    }
}
