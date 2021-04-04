package com.niuben.ui;

import com.niuben.dao.AcountDao;
import com.niuben.factory.BeanFactory;
import com.niuben.service.AcountService;
import com.niuben.service.Imp.AcountServiceImp;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.lang.annotation.AnnotationFormatError;

/**
 * 模拟表现层
 */
public class Client {
    /**
     * 获取spring的Ioc核心容器，并根据id获取对象
     *          applicationContext常用实现类
     *              1.ClassPathXmlApplicationContext : 加载类路径下的配置文件。
     *              2.FileSystemXmlApplicationContext: 加载磁盘任意路径配置文件
     *              3.AnnotationConfigApplicationContext: 读取注解创建容器
     * @param args
     */
    public static void main(String[] args) {
//       AcountService acountService = new AcountServiceImp();
//            AcountService acountService = (AcountService) BeanFactory.getBean("accountService");
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取对象
        AcountService as = (AcountService) ac.getBean("acountServiceImp2");
//        AcountDao ad = (AcountDao) ac.getBean("accountDao");
        System.out.println(as);
//        System.out.println(ad);
        as.saveAccount();
    }
}
