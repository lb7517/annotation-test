package com.lb.annotation.pay;

import com.lb.annotation.pay.factory.StrategyFactory;
import com.lb.annotation.pay.service.Strategy;

import java.math.BigDecimal;

/**
 * @author : lb
 * @date : 2020/9/3 10:41
 * @description :
 */
public class PayMainTest {
    public static void main(String[] args) throws Exception {
        StrategyFactory strategyFactory = StrategyFactory.getInstance();
        Strategy strategy = (Strategy) strategyFactory.creator(2);
        BigDecimal bigDecimal = strategy.calRecharge(2, 500);
        System.out.println("bigDecimal: " + bigDecimal);
    }
}
