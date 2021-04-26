package com.playground.test3.services;

import com.playground.test3.repositories.AccountDao;

public class AccountServiceImpl implements  AccountService{

    private AccountDao accountDao;

    public AccountServiceImpl() {
        System.out.println("AccountServiceImpl: AccountServiceImpl()");
    }
    public AccountServiceImpl(AccountDao accountDao) {
        System.out.println("AccountServiceImpl: AccountServiceImpl(AccountDao accountDao)");
        this.accountDao = accountDao;
    }
}



