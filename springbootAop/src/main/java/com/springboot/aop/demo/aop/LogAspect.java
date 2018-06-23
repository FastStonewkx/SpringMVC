package com.springboot.aop.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 切面
 */
@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(public * com.springboot.aop.demo.controller.*.*(..))")
    public void webLog(){}
    @Before("webLog()")
    public void deBefore(JoinPoint joinPoint) throws Throwable{
        //接受到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //记录下请求内容
        System.out.println("URL: "+request.getRequestURL().toString());
        System.out.println("HTTP_METHOD: "+request.getMethod());
        System.out.println("IP: "+request.getRemoteAddr());
        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }
    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable{
        //处理玩请求，返回内容
        System.out.println("方法的返回值："+ret);

    }
    @AfterThrowing("webLog()")
    public void throwing(JoinPoint jp){
        System.out.println("方法异常时执行......");
    }
    @After("webLog()")
    public void after(JoinPoint jp){
        System.out.println("方法最后执行....");
    }
    @Around("webLog()")
    public Object arround(ProceedingJoinPoint pjp){
        System.out.println("方法环绕start......");
        try{
            Object o = pjp.proceed();
            System.out.println("方法环绕proceed.结果是"+o);
            return o;
        }catch (Throwable e){
            e.printStackTrace();
            return  null;
        }
    }

}
