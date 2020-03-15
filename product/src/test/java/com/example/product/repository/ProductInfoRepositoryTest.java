package com.example.product.repository;

import com.example.product.entity.ProductInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ProductInfoRepositoryTest:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 12:49
 */
@SpringBootTest
class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    void findByProductStatus() {
        System.out.println(productInfoRepository.findAll());
    }
}