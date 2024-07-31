package com.bank.account.aspects;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
@Aspect
@Slf4j
public class LogAspect {

    // Перед выполнением методов create и update
    @Before("execution(* com.bank.account.controller.AccountDetailsController.create(..)) || " +
            "execution(* com.bank.account.controller.AccountDetailsController.update(..))")
    public void logBeforeCreateOrUpdate(JoinPoint joinPoint) {
        log.info("Перед выполнением метода " + joinPoint.getSignature().getName());
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info("methodSignature: " + methodSignature);
        log.info("methodSignature.getName() = " + methodSignature.getName());
    }

    // После успешного выполнения методов create и update
    @AfterReturning(pointcut = "execution(* com.bank.account.controller.AccountDetailsController.create(..)) || " +
            "execution(* com.bank.account.controller.AccountDetailsController.update(..))")
    public void logAfterCreateOrUpdate(JoinPoint joinPoint) {
        log.info("После выполнения метода " + joinPoint.getSignature().getName());
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        log.info("methodSignature: " + methodSignature);
        log.info("methodSignature.getName() = " + methodSignature.getName());
    }

    // После выброса исключения EntityNotFoundException
    @AfterThrowing(pointcut = "execution(* com.bank.account.controller.AccountDetailsController.*(..))", throwing = "ex")
    public void logAfterThrowing(JoinPoint joinPoint, EntityNotFoundException ex) {
        log.error("Ошибка: не найдено");
        log.error("Операция: " + joinPoint.getSignature().getName());
        log.error("Исключение: " + ex.getMessage());

    }



}
