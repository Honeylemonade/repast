package com.example.order.service.impl;

import com.example.order.client.ProductClient;
import com.example.order.dto.CartDTO;
import com.example.order.dto.OrderDTO;
import com.example.order.entity.OrderDetail;
import com.example.order.entity.OrderMaster;
import com.example.order.entity.ProductInfo;
import com.example.order.enums.OrderStatusEnum;
import com.example.order.enums.PayStatusEnum;
import com.example.order.repository.OrderDetailRepository;
import com.example.order.repository.OrderMasterRepository;
import com.example.order.service.OrderService;
import com.example.order.utils.OrderIdGenerater;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
    @Autowired
    private ProductClient productClient;

    /**
     * 创建订单
     *
     * @param orderDTO
     * @return
     */
    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        int id = OrderIdGenerater.getUniqueKey();
        //TODO 查询商品信息（调用商品服务）lamada表达式
        List<Integer> productIdList = orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfo> productInfoList = productClient.listForOrder(productIdList);

        //TODO 计算订单总价
        BigDecimal orderAmount = new BigDecimal(0);
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getProductId().equals(orderDetail.getProductId())) {
                    orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmount);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(id);
                    orderDetail.setProductIcon(productInfo.getProductPic());
                    orderDetail.setDetailId(id + new Random().nextInt(1000));
                }
            }
        }
        //TODO 扣除库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);
        //master订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(id);
        orderMaster.setBuyerId(orderDTO.getBuyerId());
        orderMaster.setBuyerName(orderDTO.getBuyerName());
        orderMaster.setBuyerPhone(orderDTO.getBuyerPhone());
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        //detail订单详情入库
        for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
            orderDetailRepository.save(orderDetail);
        }
        orderDTO.setOrderId(id);
        return orderDTO;
    }

    @Override
    public OrderDTO finish(String orderId) {
        return null;
    }
}
