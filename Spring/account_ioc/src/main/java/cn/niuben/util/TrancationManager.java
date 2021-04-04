package cn.niuben.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

//事务管理
@Component("tm")
@Aspect
public class TrancationManager {
    @Autowired
    private ConnectionUtils cu;

//    public void setCu(ConnectionUtils cu) {
//        this.cu = cu;
//    }
    @Pointcut("execution(* cn.niuben.service.*.*(.. ))")//切入点表达式
    public void p() {

    }

    //开启事务
    @Before("p()")
    public void begin() {
        try {
            cu.getCon().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //提交
    @After("p()")
    public void commit() {
        try {
            cu.getCon().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //回滚
    @AfterThrowing("p()")
    public void rollback() {
        try {
            cu.getCon().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //关闭
    @AfterReturning("p()")
    public void release() {
        try {
            cu.getCon().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            cu.conRemove();  //解绑
        }
    }

    @Around("p()")
    public Object aroundAdvise(ProceedingJoinPoint pjp) {
        Object res = null;
        try {
            Object[] args = pjp.getArgs();
            this.begin();
            res = pjp.proceed(args);
            this.commit();
        }catch (Throwable e){
            this.rollback();
            throw new RuntimeException(e);
        }finally {
            this.release();
        }
        return res;
    }
}
