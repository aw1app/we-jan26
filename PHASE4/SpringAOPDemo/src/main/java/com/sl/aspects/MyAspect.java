package com.sl.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    @Before("execution(* com.sl.BankAccount.*(..))")
    public void myAspect1(){
        System.out.println(" myAspect1 before " );
    }

    @After("execution(* com.sl.BankAccount.getBalance(..))")
    public void myAspect2(){
        System.out.println(" myAspect1 after " );
    }
}

// Task-1 : Can you code @Around advice?