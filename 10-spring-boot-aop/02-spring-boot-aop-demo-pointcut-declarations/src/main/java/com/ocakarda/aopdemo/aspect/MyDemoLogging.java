package com.ocakarda.aopdemo.aspect;

import com.ocakarda.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLogging {

    @Around("execution(* com.ocakarda.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n\n executing @Around on method: " + method);

        long begin = System.currentTimeMillis();
        Object result = null;

        try{
            result = proceedingJoinPoint.proceed();
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
            throw exception;
        }

        long end = System.currentTimeMillis();
        long duration = end - begin;

        System.out.println("\n Duration: " + duration/1000.0 + " seconds");
        return result;
    }

    @After("execution(* com.ocakarda.aopdemo.dao.AccountDao.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n\n executing @After (finally) on method: " + method);
    }


    @AfterThrowing(
            pointcut = "execution(* com.ocakarda.aopdemo.dao.AccountDao.findAccounts(..))",
            throwing = "exception"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\nExecution @AfterThrowing on method: " + method);

        System.out.println("the exception is: "+ exception.getMessage());

    }

    @AfterReturning(
            pointcut = "execution(* com.ocakarda.aopdemo.dao.AccountDao.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\nExecution @AfterReturning on method: " + method);
        System.out.println("result is: " + result);


        convertAccountNamesToUpperCase(result);
        System.out.println("result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for(Account acc : result) {
            String upperCaseName= acc.getName().toUpperCase();
            acc.setName(upperCaseName);
        }
    }


    @Before("com.ocakarda.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("\n ======> Executing @Before advice on addAccount()");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("methodSignature: "+ methodSignature);

        Object[] args = joinPoint.getArgs();

        for(Object tempArg : args) {
            System.out.println(tempArg);
            if(tempArg instanceof Account) {
                Account account = (Account) tempArg;
                System.out.println("account: " + account.getName());
                System.out.println("account: " + account.getLevel());
            }
        }
    }





}
