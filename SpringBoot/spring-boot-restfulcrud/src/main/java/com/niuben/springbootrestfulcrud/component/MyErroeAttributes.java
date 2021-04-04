package com.niuben.springbootrestfulcrud.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;


//给容器加入自己定义的错误处理信息  如何容器中存在自己实现的此类，就会用自己实现的
@Component
public class MyErroeAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        //获取父类获取的异常，并加入自己想加入的异常信息
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        errorAttributes.put("company", "牛犇");
        Map<String,Object> extend = (Map<String, Object>) webRequest.getAttribute("extend", 0);//0代表
        errorAttributes.put("exception", extend);
        return  errorAttributes;
    }
}

