package cn.niuben.service;

import cn.niuben.domain.Account;

import java.util.List;

/**
 * 账户业务层接口
 */
public interface AccountService {
    //查询所有
    List<Account> findAll();

    //查询一个
    Account findAccountById(Integer id);

    //保存
    void saveAccount(Account account);

    //更新
    void updateAccount(Account account);

    //删除
    void deleteAccount(Integer id);

    //转账
    void transfro(String source,String target,float money);
}

