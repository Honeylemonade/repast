package com.example.product.service.impl;

import com.example.product.entity.ProductCategory;
import com.example.product.repository.ProductCategoryRepository;
import com.example.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CategoryServiceImpl:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 16:08
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryIdIn(List<Integer> categoryIdList) {
        return productCategoryRepository.findByCategoryIdIn(categoryIdList);
    }
}
