package com.niuben.springbootrestfulcrud.component;

import com.sun.corba.se.spi.orbutil.closure.Closure;
import com.sun.corba.se.spi.resolver.LocalResolver;
import org.omg.CORBA.Object;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Set;

/**
 *  区域信息解析器
 *      LocaleReslover（获取区域信息对象）
 *      springboot默认配置了区域信息解析器
 *      如果指定用固定的，springboot就用固定的，若是没有就会根据请求头拿到区域信息。
 *      如果自己定义了区域信息解析器，springboot就会自动识别我们的区域信息解析器
 *
 */
public class MyLocaleReslover implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String lang = httpServletRequest.getParameter("lang");
        //先将locale设置为默认的，后面如果过得了，就覆盖，没有就使用默认的
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(lang)) {
            String[] s = lang.split("_");
            locale = new Locale(s[0], s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
