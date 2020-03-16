package com.example.order.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * OrderMaster:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 17:46
 */
@Data
@Entity
public class OrderMaster {
    /**
     * 订单id.
     */
    @Id
    @GeneratedValue
    private Integer orderId;

    /**
     * 买家名字.
     */
    private String buyerName;

    /**
     * 买家手机号.
     */
    private String buyerPhone;

    /**
     * 买家微信Openid.
     */
    private String buyerId;

    /**
     * 订单总金额.
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态, 默认为0新下单.
     */
    private Integer orderStatus;

    /**
     * 支付状态, 默认为0未支付.
     */
    private Integer payStatus;
}
