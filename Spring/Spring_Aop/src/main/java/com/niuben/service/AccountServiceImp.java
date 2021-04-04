package com.niuben.service;

import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImp implements AccountService {
    public void saveAccount() {
        System.out.println("保存");
    }

    public void updataAccount(int i) {
        System.out.println("更新");
    }

    public int deleteAccount() {
        System.out.println("删除");
        return 0;
    }
}
