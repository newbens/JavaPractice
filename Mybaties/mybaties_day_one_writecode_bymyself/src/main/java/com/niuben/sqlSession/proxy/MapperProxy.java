package com.niuben.sqlSession.proxy;

import com.niuben.cfg.Mapper;
import com.niuben.utils.Executor;
import javafx.beans.InvalidationListener;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {

    private Connection connection;
    private Map<String, Mapper> mappers;

    public MapperProxy(Map<String,Mapper> mappers,Connection connection) {
        this.mappers = mappers;
        this.connection = connection;

    }
    /**
     * 增强方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.获取方法名
        String methodName = method.getName();
        String classpath = method.getDeclaringClass().getName();
        String key = classpath + "." + methodName;
        Mapper mapper = mappers.get(key);
        if (mapper == null) {
            throw new IllegalArgumentException("传参错误");
        }
        return new Executor().selectList(mapper,connection);

    }
}
