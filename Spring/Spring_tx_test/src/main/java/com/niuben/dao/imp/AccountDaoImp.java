package com.niuben.dao.imp;

import com.niuben.dao.AccountDao;
import com.niuben.dao.JdbcDaoSupport;
import com.niuben.domian.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;
import java.util.List;
@Repository("accountDao")
public class AccountDaoImp extends JdbcDaoSupport implements AccountDao {
    @Autowired
    private JdbcTemplate jt;

    @Override
    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }

    public Account findById(int id) {
        List<Account> query = jt.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return query.isEmpty() ? null : query.get(0);
    }

    public Account findByName(String name) {
        List<Account> query = jt.query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if (query.size() > 1) {
            throw new  RuntimeException("结果集不唯一");
        } else if (query.size() == 0) {
            return null;
        }else {
            return query.get(0);
        }
    }

    public void updateAccount(Account account) {
        jt.update("update account set name=?,money=? where id=?", account.getName(), account.getMoney(),account.getId());
    }

    public void transfor(String s, String t, float m) {
        Account byName = findByName(s);
        byName.setMoney(byName.getMoney()-m);
        Account byName1 = findByName(t);
        byName1.setMoney(byName1.getMoney()+m);
        updateAccount(byName);
        updateAccount(byName1);
    }


}
