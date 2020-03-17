package com.example.order.service.impl;

import com.example.order.dto.OrderDTO;
import com.example.order.entity.OrderMaster;
import com.example.order.enums.OrderStatusEnum;
import com.example.order.enums.PayStatusEnum;
import com.example.order.repository.OrderDetailRepository;
import com.example.order.repository.OrderMasterRepository;
import com.example.order.service.OrderService;
import com.example.order.utils.OrderIdGenerater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * OrderServiceImpl:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 20:16
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    /**
     * 创建订单
     *
     * @param orderDTO
     * @return
     */
    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        //TODO 查询商品信息
        //TODO 计算订单总价
        //TODO 扣除库存
        //订单入库
        //master订单
        OrderMaster orderMaster = new OrderMaster();
        int id = OrderIdGenerater.getUniqueKey();
        orderMaster.setOrderId(id);
        orderMaster.setBuyerId(orderDTO.getBuyerId());
        orderMaster.setBuyerName(orderDTO.getBuyerName());
        orderMaster.setBuyerPhone(orderDTO.getBuyerPhone());
        //随便设置一个金额
        orderMaster.setOrderAmount(new BigDecimal(10.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderDTO.setOrderId(id);
        return orderDTO;
    }

    @Override
    public OrderDTO finish(String orderId) {
        return null;
    }
}
