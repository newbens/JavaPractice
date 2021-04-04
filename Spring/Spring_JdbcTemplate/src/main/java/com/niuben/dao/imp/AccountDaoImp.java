package com.niuben.dao.imp;

import com.niuben.dao.AccountDao;
import com.niuben.dao.JdbcDaoSupport;
import com.niuben.domian.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.management.RuntimeErrorException;
import java.util.List;

public class AccountDaoImp extends JdbcDaoSupport implements AccountDao {


    public Account findById(int id) {
        List<Account> query = super.getJt().query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return query.isEmpty() ? null : query.get(0);
    }

    public Account findByName(String name) {
        List<Account> query = super.getJt().query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if (query.size() > 1) {
            throw new  RuntimeException("结果集不唯一");
        } else if (query.size() == 0) {
            return null;
        }else {
            return query.get(0);
        }
    }

    public void updateAccount(Account account) {
        super.getJt().update("update account set name=?,money=? where id=?", account.getName(), account.getMoney());
    }
}
