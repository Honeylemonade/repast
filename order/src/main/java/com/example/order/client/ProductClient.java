package com.example.order.client;

import com.example.order.dto.CartDTO;
import com.example.order.entity.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * ProductClient:
 *
 * @Author XvYanpeng
 * @Date 2020/3/17 16:49
 */
@FeignClient(value = "product")
public interface ProductClient {
    @GetMapping("/product/msg")
    String productMsg();

    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<Integer> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);
}
