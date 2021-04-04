package com.niuben.dao;

import com.niuben.domain.Account;

import java.util.List;

public interface AccountDao {
    //查询账户用时查询账户的user
    List<Account> findAll();

    List<Account> findAccountByUid(Integer id);
}
