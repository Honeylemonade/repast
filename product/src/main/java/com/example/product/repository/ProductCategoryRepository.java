package com.example.product.repository;

import com.example.product.entity.ProductCategory;
import com.example.product.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ProductCategory:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 16:04
 */
@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Integer> {
    /**
     * 查询类别编号位于{.....}的商品类别
     *
     * @return
     */
    List<ProductCategory> findByCategoryIdIn(List<Integer> categoryIdList);
}
