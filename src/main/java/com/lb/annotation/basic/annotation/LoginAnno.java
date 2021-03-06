package com.lb.annotation.basic.annotation;

import java.lang.annotation.*;

/**
 * @author : lb
 * @date : 2020/9/3 9:45
 * @description :
 */
// 注解信息会被添加到Java文档中
@Documented
// 注解的生命周期，表示注解会被保留到什么阶段，可以选择编译阶段、类加载阶段，或运行阶段
@Retention(RetentionPolicy.RUNTIME)
// 注解作用的位置，ElementType.METHOD表示该注解仅能作用于方法上
@Target(ElementType.METHOD)
public @interface LoginAnno {
}
