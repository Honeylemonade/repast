package com.example.product.vo;

import lombok.Data;

/**
 * ResultVO:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 17:14
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
