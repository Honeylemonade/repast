package com.example.order.repository;

import com.example.order.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * OrderDetailRepository:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 17:48
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
