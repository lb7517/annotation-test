### 自定义注解

1. **基本自定义注解**：实现在com.lb.annotation.basic.annotation包中
说明: 
* @Documented注解信息会被添加到Java文档中
* @Retention注解的生命周期，表示注解会被保留到什么阶段，可以选择编译阶段、类加载阶段，或运行阶段, 一般使用RetentionPolicy.RUNTIME
* @Target注解作用的位置ElementType.METHOD表示该注解仅能作用于方法上

* * *

2. **通过自定义注解实现不同支付:** 实现在
com.lb.annotation.pay包中
说明:
* 使用自定义注解和反射实现简单支付

* * *

3. **通过自定义注解+切面实现简单的鉴权登入** com.lb.annotation.author包中
注意:

    * 使用ProceedingJoinPoint接受参数，并且解析方法中的注解
    *  切面的实现方式有两种: 方式一通过@Pointcut加注解类路径@annotation()实现；方式二 通过 @annotation(形参test)方式现实

[工程地址](https://github.com/lb7517/annotation-test.git)