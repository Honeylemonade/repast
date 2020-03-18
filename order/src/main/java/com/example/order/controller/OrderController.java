package com.example.order.controller;

import com.example.order.client.ProductClient;
import com.example.order.converter.OrderForm2OrderDTOConverter;
import com.example.order.dto.OrderDTO;
import com.example.order.entity.OrderDetail;
import com.example.order.entity.ProductInfo;
import com.example.order.enums.ResultEnum;
import com.example.order.form.OrderForm;
import com.example.order.service.OrderService;
import com.example.order.vo.ResultVO;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * OrderController:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 18:06
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductClient productClient;

    /**
     * 创建订单
     *
     * @param orderForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/create")
    public ResultVO<Map<String, Integer>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        //1，校验参数
        if (bindingResult.hasErrors()) {
            log.error("订单出错");
        } else {
            OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
            OrderDTO result = orderService.create(orderDTO);
            Map<String, Integer> map = new HashMap<>();
            map.put("orderId", result.getOrderId());
            return new ResultVO<Map<String, Integer>>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), map);
        }

        return null;
    }

}
