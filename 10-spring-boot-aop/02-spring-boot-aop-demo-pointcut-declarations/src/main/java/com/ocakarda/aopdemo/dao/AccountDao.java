package com.ocakarda.aopdemo.dao;

import com.ocakarda.aopdemo.Account;

import java.util.List;

public interface AccountDao {
    void addAccount(Account account);

    String getName();
    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);

    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);
}
