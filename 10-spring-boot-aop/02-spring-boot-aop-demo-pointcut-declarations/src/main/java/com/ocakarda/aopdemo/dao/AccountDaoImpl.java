package com.ocakarda.aopdemo.dao;

import com.ocakarda.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao{

    private String name;

    private String serviceCode;

    @Override
    public void addAccount(Account account) {
        System.out.println(getClass()+ " doing my db work: adding account");
    }

    public String getName() {
        System.out.println(getClass()+ ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+ ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+ ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+ ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        List<Account> myAccounts = new ArrayList<>();
        if(tripWire) {
            throw new RuntimeException("no soup for you");

        }
        Account temp1 = new Account("john", "1");
        Account temp2 = new Account("amy", "2");
        Account temp3 = new Account("Emma", "3");
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }
}
