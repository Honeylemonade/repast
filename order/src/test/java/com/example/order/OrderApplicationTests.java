package com.example.order;

import com.example.order.entity.OrderMaster;
import com.example.order.repository.OrderMasterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class OrderApplicationTests {
    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Test
    void contextLoads() {
        OrderMaster orderMaster = new OrderMaster(123123, "asd", "asdas", "qwe", new BigDecimal(123), 0, 0);
        orderMasterRepository.save(orderMaster);
    }

}
