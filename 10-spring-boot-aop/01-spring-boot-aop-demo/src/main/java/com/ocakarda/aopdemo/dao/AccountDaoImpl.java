package com.ocakarda.aopdemo.dao;

import com.ocakarda.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{

    @Override
    public void addAccount(Account account) {
        System.out.println(getClass()+ " doing my db work: adding account");
    }
}
