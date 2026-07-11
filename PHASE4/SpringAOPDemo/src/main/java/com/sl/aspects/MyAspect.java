package com.sl.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

//    @Before("execution(* com.sl.BankAccount.*(..))")
//    public void myAspect1(){
//        System.out.println(" myAspect1 before " );
//    }

//    @After("execution(* com.sl.BankAccount.*(..))")
//    public void myAspect2(){
//        System.out.println(" myAspect1 after " );
//    }

    // This 'around' advice is only for BankAccount's getBalance() method
    @Around("execution(* com.sl.BankAccount.getBalance(..))")
    public Object myAspect3(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println(" myAspect1 around before 1" );
        System.out.println(" myAspect1 around before 2 " );

        Object result = joinPoint.proceed(); // this will let getBalance(..) to be executed and return

        System.out.println(" myAspect1 around after 1" );
        System.out.println(" myAspect1 around after 2" );

        return result;
    }

    @AfterReturning(pointcut="execution(* com.sl.BankAccount.withdraw(..))", returning = "result")
    public void m3(double result) {
        if (result>1000)
        System.out.println("(LOG) AfterReturning : Amount withdrawn = " + result);
    }

    // execute the below advice only if the pointcut throws exception.
    @AfterThrowing(pointcut="execution(* com.sl.BankAccount.withdrawOnHolidays(..))", throwing = "ex")
    public void m3(Throwable ex) {
        System.out.println("(LOG) AfterThrowing :Exception message = " + ex.getMessage());
    }
}

// Task-1 : Can you code @Around advice?