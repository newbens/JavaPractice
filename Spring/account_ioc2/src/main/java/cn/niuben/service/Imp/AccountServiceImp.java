package cn.niuben.service.Imp;

import cn.niuben.dao.AccountDao;
import cn.niuben.domain.Account;
import cn.niuben.service.AccountService;
import cn.niuben.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层实现类
 */
@Service("accountService")
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountDao accountDao;
    private TransactionManager tm;

    public void setTm(TransactionManager tm) {
        this.tm = tm;
    }

    public List<Account> findAll() {
        try {
            //1.开启事务
            tm.begin();
            List<Account> all = accountDao.findAll();
            //2.提交事务
            tm.commit();
            return all;
        }catch (Exception e){
            tm.rollback();
        }finally {
            tm.release();
        }
        return null;
    }

    public Account findAccountById(Integer id) {
        try {
            //1.开启事务
            tm.begin();
            System.out.println("tm"+tm);
            Account account = accountDao.findAccountById(id);
            //2.提交事务
            tm.commit();
            return account;
        }catch (Exception e){
            tm.rollback();
        }finally {
            tm.release();
        }
        return null;
    }

    public void saveAccount(Account account) {
        try {
            //1.开启事务
            tm.begin();
            accountDao.saveAccount(account);
            //2.提交事务
            tm.commit();
        }catch (Exception e){
            tm.rollback();
        }finally {
            tm.release();
        }
    }

    public void updateAccount(Account account) {
        try {
            //1.开启事务
            tm.begin();
            accountDao.updateAccount(account);
            //2.提交事务
            tm.commit();
        }catch (Exception e){
            tm.rollback();
        }finally {
            tm.release();
        }
    }

    public void deleteAccount(Integer id) {
        try {
            //1.开启事务
            tm.begin();
            accountDao.deleteAccount(id);
            //2.提交事务
            tm.commit();
        }catch (Exception e){
            tm.rollback();
        }finally {
            tm.release();
        }
    }

    /**
     *
     * @param source  转出账户名称
     * @param target   收账账户
     * @param money     金额
     */
    public void transfro(String source, String target, float money) {
        try {
            //1.开启事务
            tm.begin();
            Account s = accountDao.findAccountByName(source);
            Account t = accountDao.findAccountByName(target);
            System.out.println(s.getName());
            System.out.println(t.getName());
            s.setMoney(s.getMoney()-money);
            t.setMoney(t.getMoney()+money);
            accountDao.updateAccount(s);
            accountDao.updateAccount(t);
            //2.提交事务
            tm.commit();
        }catch (Exception e){
            tm.rollback();
        }finally {
            tm.release();
        }
    }
}
