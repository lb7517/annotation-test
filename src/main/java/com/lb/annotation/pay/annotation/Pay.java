package com.lb.annotation.pay.annotation;

import java.lang.annotation.*;

/**
 * @author : lb
 * @date : 2020/9/3 10:22
 * @description :
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Pay {

    int value() default 0;

}
