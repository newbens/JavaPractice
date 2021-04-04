package cn.niuben.service.Imp;

import cn.niuben.dao.AccountDao;
import cn.niuben.domain.Account;
import cn.niuben.service.AccountService;
import cn.niuben.util.TrancationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层实现类
 */
@Component("accountService")
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Autowired
    private TrancationManager tm;

//    public void setAccountDao(AccountDao accountDao) {
//        this.accountDao = accountDao;
//    }
//
//    public void setTm(TrancationManager tm) {
//        this.tm = tm;
//    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }

    public void transFor(String source, String target, int money) {
        accountDao.transfor(source,target,money);
    }
}
