package com.ocakarda.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogging {


//    @Before("execution(public void com.ocakarda.aopdemo.dao.AccountDaoImpl.addAccount())")
    @Before("execution(* add*(com.ocakarda.aopdemo.Account))")
//    @Before("execution(public void add*())") will execute if method is starting with add
//    @Before("execution(public * beforeAddAccountAdvice())") any return type
    public void beforeAddAccountAdvice(){
        System.out.println("\n ======> Executing @Before advice on addAccount()");
    }

}
