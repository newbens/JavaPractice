package cn.niuben.dao.Imp;

import cn.niuben.dao.AccountDao;
import cn.niuben.domain.Account;
import cn.niuben.util.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
@Component("accountDao")
public class AccountDaoImp implements AccountDao {
    @Autowired
    private QueryRunner runner;
    @Autowired
    private ConnectionUtils cu;

//    public AccountDaoImp() {
//
//    }

//    public void setRunner(QueryRunner runner) {
//        this.runner = runner;
//    }
//
//    public void setCu(ConnectionUtils cu) {
//        this.cu = cu;
//    }

//    public AccountDaoImp(ConnectionUtils cu) {
//        this.cu = cu;
//    }

    public List<Account> findAll() {
        try {
            return runner.query(cu.getCon(),"select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Account findAccountById(Integer id) {
        try {
            return runner.query(cu.getCon(),"select * from account where id = ?", new BeanHandler<Account>(Account.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveAccount(Account account) {
        try {
            runner.update(cu.getCon(),"insert into account (name,money)values(?,?)",account.getName(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update(cu.getCon(),"update account set name = ? , money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(Integer id) {
        try {
            runner.update(cu.getCon(),"delete from account where id = ?",id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void transfor(String source, String target, int money) {
        try {
            Account s = runner.query(cu.getCon(),"select * from account where name = ?", new BeanHandler<Account>(Account.class), source);
            s.setMoney(s.getMoney()-money);
            updateAccount(s);
            Account t = runner.query(cu.getCon(),"select * from account where name = ?", new BeanHandler<Account>(Account.class), target);
            t.setMoney(t.getMoney()+money);
            updateAccount(t);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
