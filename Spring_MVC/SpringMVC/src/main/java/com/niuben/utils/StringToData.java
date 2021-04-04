package com.niuben.utils;

import javafx.scene.input.DataFormat;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * 字符串转日期
 */
public class StringToData implements Converter<String, Date> {
    /**
     * @param s 传入字符串的值
     * @return 返回日期对象
     */
    @Override
    public Date convert(String s) {
        if (s == null) {
            throw new RuntimeException("请输入数据");
        }
        try {
            Date d = new SimpleDateFormat("yyyy-MM-dd").parse(s);
           return  d;
        } catch (ParseException e) {
            throw new RuntimeException("数据类型转换出现异常！");
        }
    }
}
