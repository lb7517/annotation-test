package com.lb.annotation.pay.service.impl;

import com.lb.annotation.pay.annotation.Pay;
import com.lb.annotation.pay.service.Strategy;

import java.math.BigDecimal;

/**
 * @author : lb
 * @date : 2020/9/3 10:26
 * @description :
 */
@Pay(2)
public class ICBCPay implements Strategy {
    @Override
    public BigDecimal calRecharge(Integer channelId, Integer goodsId) {
        System.out.println("ICBC pay");
        return new BigDecimal(100);
    }
}
