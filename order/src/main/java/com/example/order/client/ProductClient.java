package com.example.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ProductClient:
 *
 * @Author XvYanpeng
 * @Date 2020/3/17 16:49
 */
@FeignClient(name = "product")
public interface ProductClient {
    @GetMapping("/product/msg")
    String productMsg();
}
