package com.example.order.vo;

import lombok.Data;

/**
 * ResultVO:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 18:26
 */
@Data
public class ResultVO<T> {
    private Integer code;

    private String msg;

    private T data;
}
