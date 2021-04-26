package com.playground.test3.repositories;

import com.playground.test3.models.Account;

public class AccountDaoImpl implements AccountDao{

    public Account account;

    public  AccountDaoImpl (){
        System.out.println("AccountDaoImpl:AccountDaoImpl()");
    }
    public AccountDaoImpl(Account account){
        System.out.println("AccountDaoImpl:AccountDaoImpl(Account account), Account hash ="+account.hashCode());
        this.account = account;
    }
}
