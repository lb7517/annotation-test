package com.lb.annotation.pay.factory;

import com.lb.annotation.pay.annotation.Pay;
import com.lb.annotation.pay.service.Strategy;
import org.reflections.Reflections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author : lb
 * @date : 2020/9/3 10:28
 * @description :
 */
public class StrategyFactory {

    private static StrategyFactory factory = new StrategyFactory();

    public static StrategyFactory getInstance() {
        return factory;
    }

    public static Map<Integer, String> map = new HashMap<>();

    static {
        //反射工具包，指明扫描路径
        Reflections reflections = new Reflections("com.lb.annotation.pay.service.impl");
        Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(Pay.class);
        for(Class clazz : classSet){
            Pay pay = (Pay) clazz.getAnnotation(Pay.class);
            map.put(pay.value(), clazz.getCanonicalName());
        }
    }

    public Strategy creator(int type) throws Exception {
        // 取得全类名
        String className = map.get(type);
        // 取得类对象
        Class clazz = Class.forName(className);
        // 反射创建对象
        return (Strategy) clazz.newInstance();
    }
}
