package com.example.product.service;

import com.example.product.entity.ProductCategory;

import java.util.List;

/**
 * CategoryService:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 16:08
 */
public interface CategoryService {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
