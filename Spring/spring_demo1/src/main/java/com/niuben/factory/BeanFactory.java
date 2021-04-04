package com.niuben.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 创建Bean对象的工厂类
 * Bean-可重用组件。
 */
public class BeanFactory {
    private static Properties properties;
    //定义一个Map,存放对象
    private static Map<String,Object> beans;
    static {
        try {
            properties = new Properties();
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(in);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件的所有key
            Enumeration<Object> keys = properties.keys();
            //遍历枚举，创建对象
            while (keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                String beanPath = properties.getProperty(key);
                Object bean = Class.forName(beanPath).newInstance();
                beans.put(key, bean);
            }
        } catch (IOException e) {
            //初始化错误
            throw new ExceptionInInitializerError();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param beanname bean名称
     * @return 返回bean对象
    */
    public static Object getBean(String beanname) {
//        Object bean = null;
//        try {
//            String beanPath = properties.getProperty(beanname);
//            bean = Class.forName(beanPath).newInstance();
//
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    return bean;
//    }

        //改进
        return beans.get(beanname);
}

    public String getbean() {
        return null;
    }
}
