package com.example.product.service;

import com.example.product.entity.ProductInfo;

import java.util.List;

/**
 * ProductService:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 14:54
 */
public interface ProductService {
    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();
}
