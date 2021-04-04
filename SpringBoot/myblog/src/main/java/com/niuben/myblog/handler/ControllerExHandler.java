package com.niuben.myblog.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 拦截异常
 */
@ControllerAdvice  //这个注解会拦截 所有有@controller的类
public class ControllerExHandler {
    //获取异常处理器
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    public ModelAndView excepetionHander(HttpServletRequest request,Exception e) {
        //通过HttpServletRequest对象获取到请求链接
        logger.error("Request URL: {} exception: {}",request.getRequestURL(),e);
        //存入MoldeAndView对象
        ModelAndView m = new ModelAndView();
        m.addObject("url",request.getRequestURL());
        m.addObject("exception",e);
        //定义跳转页面
        m.setViewName("error/error");
        return m;
    }
}
