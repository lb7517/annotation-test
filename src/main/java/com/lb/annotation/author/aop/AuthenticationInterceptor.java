package com.lb.annotation.author.aop;

import com.lb.annotation.author.annotation.Access;
import com.lb.annotation.author.entity.User;
import com.lb.annotation.author.exception.UserException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : lb
 * @date : 2020/9/3 18:08
 * @description : 过滤器
 */
@Component
@Aspect
//public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
public class AuthenticationInterceptor {

    /**
     * @Around实现有两种，方式一:
     * */
    @Pointcut("@annotation(com.lb.annotation.author.annotation.Access)")
    private void cut(){}

    @Around("cut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        // 通过传进来的参数进行权限校验，理论上要去数据库查出权限
        Object[] args = joinPoint.getArgs();
        User user = (User) args[0];
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodNAME = signature.getName();

        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        Access access = method.getAnnotation(Access.class);
        String[] authorities = access.authorities();
        Set<String> authSet = new HashSet<>();
        for(String authority: authorities){
            authSet.add(authority);
        }
        // 正常情况是通过这个参数去数据库查找是否有权限
        if(authSet.contains(user.getRole())){
            return joinPoint.proceed();
        }
        throw new UserException("没有权限");
    }


    /**
     * @Around实现有两种，方式二:
     *  @annotation(形参test)
     * */
    /*@Around("@annotation(access)")
    public Object around(ProceedingJoinPoint joinPoint, Access access) throws Throwable {
        Signature signature = joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();
        User user = (User) args[0];
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodNAME = signature.getName();

        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        String[] authorities = access.authorities();
        Set<String> authSet = new HashSet<>();
        for(String authority: authorities){
            authSet.add(authority);
        }
        // 正常情况是通过这个参数去数据库查找是否有权限
        if(authSet.contains(user.getRole())){
            return joinPoint.proceed();
        }
        throw new UserException("没有权限");
    }*/
}
