package test;

import cn.niuben.domain.Account;
import cn.niuben.service.AccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
public class AccountServiceTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    AccountService as = ac.getBean("accountService", AccountService.class);

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
    public void testTransFor() {
        as.transfro("aaa","bbb",100f);
    }
}
