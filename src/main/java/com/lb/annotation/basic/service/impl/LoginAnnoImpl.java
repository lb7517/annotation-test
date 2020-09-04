package com.lb.annotation.basic.service.impl;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author : lb
 * @date : 2020/9/3 9:52
 * @description :
 */
@Aspect
@Component
public class LoginAnnoImpl {

    @Pointcut("@annotation(com.lb.annotation.basic.annotation.LoginAnno)")
    private void cut(){}

    @Before("cut()")
    public void before(){
        System.out.println("自定义注解生效了");
    }
}
