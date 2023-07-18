package com.ocakarda.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public void addAccount() {
        System.out.println(getClass()+ " doing my db work:  adding membership");
    }

    @Override
    public void addSillyAccount() {
        System.out.println(getClass()+ " doing my db work:  adding silly membership");

    }
}
