package com.niuben.service.Imp;

import com.niuben.dao.AccountDao;
import com.niuben.service.AccountService;
import com.niuben.dao.AccountDao;
import com.niuben.domian.Account;
import com.niuben.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 业务层实现类
 */
@Service("accountService")
@Transactional  //加入事务管理
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    //    public void setAccountDao(AccountDao accountDao) {
//        this.accountDao = accountDao;
//    }
//
//    public void setTm(TrancationManager tm) {
//        this.tm = tm;
//    }


    public Account fingById(int id) {
        return accountDao.findById(id);
    }

    public void transfor(String s, String t, float m) {
        accountDao.transfor(s,t,m);
    }
}
