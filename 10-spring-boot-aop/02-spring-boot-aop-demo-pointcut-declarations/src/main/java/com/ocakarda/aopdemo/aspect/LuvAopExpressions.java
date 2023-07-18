package com.ocakarda.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
    @Pointcut("execution(* com.ocakarda.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {};

    @Pointcut("execution(* com.ocakarda.aopdemo.dao.*.get*(..))")
    public void getter() {};

    @Pointcut("execution(* com.ocakarda.aopdemo.dao.*.set*(..))")
    public void setter() {};

    @Pointcut("forDaoPackage() && !(getter() || setter() )")
    public void forDaoPackageNoGetterSetter() {};

}
