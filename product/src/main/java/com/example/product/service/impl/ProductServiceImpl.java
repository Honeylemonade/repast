package com.example.product.service.impl;

import com.example.product.entity.ProductInfo;
import com.example.product.enums.ProductStatusEnum;
import com.example.product.repository.ProductInfoRepository;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProductServiceImpl:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 14:54
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;
    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
