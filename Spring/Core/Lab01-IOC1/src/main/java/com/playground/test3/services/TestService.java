package com.playground.test3.services;

public class TestService {

    AccountService accountService;

    public TestService(){}

    public TestService(AccountService accountService) {
        System.out.println("TestService: TestService(AccountService accountService)");
        this.accountService = accountService;
    }
}
