package com.niuben.controller.Exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器 必须继承接口HandlerExceptionResolver
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                HttpServletResponse httpServletResponse, Object o, Exception e) {
        //获取异常对象
        SysException s = null;
        if(e instanceof SysException){
            e = (SysException) e;
        }else {
            e = new SysException("系统正在维护");
        }
        ModelAndView m = new ModelAndView();
        m.addObject("error",e.getMessage());
        m.setViewName("error");
        return m;
    }
}
