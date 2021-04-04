package com.niuben.service;

import com.niuben.domian.Account;

public interface AccountService {
    Account fingById(int id);

    /**
     *
     * @param s  转出账户
     * @param t   转入账户
     * @param m     金额
     */
    void transfor(String s, String t, float m);
}
