package com.springboot.aop.demo.aop;

import com.springboot.aop.demo.desc.UserAccess;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserAccessAspect {
    @Pointcut(value = "@annotation(com.springboot.aop.demo.desc.UserAccess)")
    public void access(){

    }
    @Before("access()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        System.out.println("couple before");
    }
    @Around("@annotation(userAccess)")
    public Object around(ProceedingJoinPoint pjp, UserAccess userAccess){
        System.out.println("couple around:" +userAccess.desc());
        try {
            return pjp.proceed();
        }catch (Throwable e){
            e.printStackTrace();
            return "Something null";
        }
    }
}
