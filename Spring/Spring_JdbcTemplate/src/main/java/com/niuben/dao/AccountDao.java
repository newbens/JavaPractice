package com.niuben.dao;

import com.niuben.domian.Account;

public interface AccountDao {
    Account findById(int id);

    Account findByName(String name);

    void updateAccount(Account account);
}
