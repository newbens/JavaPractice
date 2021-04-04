package cn.niuben.test;

//import cn.niuben.config.SpringConfigration;
import cn.niuben.config.SpringConfigration;
import cn.niuben.domain.Account;
import cn.niuben.service.AccountService;
import javafx.application.Application;
import javafx.application.Platform;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import sun.security.krb5.SCDynamicStoreConfig;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

    ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfigration.class);
    AccountService as = (AccountService)ac.getBean("accountService");

//    @Autowired
//    AccountService as;
    @Test
    public void testFindAll() {
        List<Account> all = as.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindById() {
        int id = 2;
        Account accountById = as.findAccountById(id);
        System.out.println(accountById);
    }

    @Test
    public void testUpdate() {
        int id = 2;
        Account accountById = as.findAccountById(id);
        accountById.setMoney(8888);
        as.updateAccount(accountById);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("牛犇");
        account.setMoney(100000000);
        as.saveAccount(account);
    }

    @Test
    public void testDelete() {
        as.deleteAccount(4);
    }

    @Test
    public void testTran() {
        as.transFor("aaa","bbb",10);
    }

}
