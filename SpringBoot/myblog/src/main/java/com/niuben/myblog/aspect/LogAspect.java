package com.niuben.myblog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect  //此类会被当成一个切面
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());//拿到日志记录器
    //设置切点
    @Pointcut("execution(* com.niuben.myblog.web.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")  //在切面之前执行
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        //方法和类 需要aop里面的对象获取
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        String name = joinPoint.getSignature().getName();
        String classMethod = declaringTypeName + name;
        //获取参数
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        //封装
        logger.info("REQUEST: {}",requestLog);
    }

    @After("log()")
    public void doAfter() {
        logger.info("-----------------------doAfter---------------------------");
    }
    //将返回对象存入日志
    @AfterReturning(returning = "o",pointcut = "log()")
    public void afterReturn(Object o) {
        logger.info("Result: {} ",o);
    }

    //定义内部类进行分装
    private class RequestLog {
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
