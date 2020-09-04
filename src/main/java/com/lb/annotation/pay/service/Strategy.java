package com.lb.annotation.pay.service;

import java.math.BigDecimal;

/**
 * @author : lb
 * @date : 2020/9/3 10:24
 * @description :
 */
public interface Strategy {

    /**
     *  计算支付金额 通过渠道id和商品id 进行价格计算
     * */
    BigDecimal calRecharge(Integer channelId, Integer goodsId);

}
