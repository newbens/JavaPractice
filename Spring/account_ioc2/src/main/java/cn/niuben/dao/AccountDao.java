package cn.niuben.dao;

import cn.niuben.domain.Account;

import java.util.List;

public interface AccountDao {
    //查询所有
    List<Account> findAll() ;

    //查询一个
    Account findAccountById(Integer id) ;

    //保存
    void saveAccount(Account account);

    //更新
    void updateAccount(Account account);

    //删除
    void deleteAccount(Integer id);

    Account findAccountByName(String name);
}
