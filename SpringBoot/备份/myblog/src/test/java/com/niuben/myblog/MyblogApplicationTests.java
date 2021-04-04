package com.niuben.myblog;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.niuben.myblog.domain.Type;
import com.niuben.myblog.service.BlogService;
import com.niuben.myblog.service.TypeService;
import org.aspectj.weaver.NewParentTypeMunger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MyblogApplicationTests {
    @Autowired
    DataSource dataSource;
    @Autowired
    TypeService typeService;
    @Autowired
    BlogService blogService;

    @Test
    void contextLoads() {
        System.out.println(dataSource.getClass());
    }

    @Test
    public void test() {
        Integer count = typeService.findCount();
        System.out.println(count);
    }
    @Test
    public void test2() {
        PageHelper.startPage(1, 3);
        PageInfo<Type> pageInfo = new PageInfo<>(typeService.getPage());
        List<Type> list = pageInfo.getList();
        Type type = list.get(1);
        System.out.println(type);
    }

    @Test
    public void test3() {
        Type type = new Type();
        type.setId((long) 8);
        type.setName("JavaScript");
        int i = typeService.saveType(type);
        System.out.println(i);
    }



}
