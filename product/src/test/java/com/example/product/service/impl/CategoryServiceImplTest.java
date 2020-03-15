package com.example.product.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * CategoryServiceImplTest:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 17:11
 */
@SpringBootTest
class CategoryServiceImplTest {
    @Autowired
    CategoryServiceImpl categoryService;

    @Test
    void findByCategoryTypeIn() {
        System.out.println(categoryService.findByCategoryTypeIn(Arrays.asList(11,22)));
    }
}