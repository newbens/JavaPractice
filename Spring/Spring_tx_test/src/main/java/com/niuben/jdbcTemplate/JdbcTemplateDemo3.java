package com.niuben.jdbcTemplate;

import com.niuben.dao.AccountDao;
import com.niuben.domian.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);
        Account aaa = accountDao.findByName("aaa");
        System.out.println(aaa.getMoney());

    }
}
