package com.example.product.repository;

import com.example.product.entity.ProductInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ProductInfoRepository:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 12:43
 */
@Repository
public interface ProductInfoRepository extends CrudRepository<ProductInfo, String> {
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
