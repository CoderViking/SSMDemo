package com.ssm.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * created by viking on 2018/07/15
 * aop切面
 */
@Component
@Aspect
public class AopServerAspectj {
    protected Logger log = Logger.getLogger(this.getClass());

    //"execution(* com..mapper..*(..))" //mapper层中的任意方法
    //"execution(* com..controller..*.*(..))"//controller层中的任意方法
    // "execution(* com..service..*(..))"//service层中的任一方法
    @Pointcut("execution(* com..controller..*(..))")
    public void cutPoint(){}


    @Around("cutPoint()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("==========>"+joinPoint.getTarget().getClass()+":around~");

        return joinPoint.proceed();
    }
    @Before("cutPoint()")
    public void beforeCut(JoinPoint joinPoint){
        Class<?> clazz = joinPoint.getTarget().getClass();
        log.info(clazz+":before aop");
        Method[] declaredMethods = clazz.getDeclaredMethods();  //所有申明的方法（不包括继承的）
        for (Method m : declaredMethods){
            System.out.println("the declaredMethod of this class:"+m.getName());
        }
    }
    @AfterReturning("cutPoint()")
    public void afterCut(JoinPoint joinPoint){
        Class<?> clazz = joinPoint.getTarget().getClass();
        log.info(clazz+":after aop");
        Method[] declaredMethods = clazz.getDeclaredMethods();  //所有申明的方法（不包括继承的）
        for (Method m : declaredMethods){
            System.out.println("the declaredMethod of this class:"+m.getName());
        }
    }
}
