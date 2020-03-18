package com.example.product;

import com.example.product.entity.ProductInfo;
import com.example.product.repository.ProductInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ProductApplicationTests {
    @Autowired
    ProductInfoRepository productInfoRepository;
    @Test
    void contextLoads() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        List<ProductInfo> arrayList = productInfoRepository.findByProductIdIn(list);
        int a = 1;
    }
}
