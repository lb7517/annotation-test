package com.lb.annotation.author.annotation;

import java.lang.annotation.*;

/**
 * @author : lb
 * @date : 2020/9/3 18:03
 * @description :
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Access {
    String[] authorities() default {};
}
