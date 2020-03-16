package com.example.product.enums;

import lombok.Getter;

/**
 * ResultCodeEnum:
 *
 * @Author XvYanpeng
 * @Date 2020/3/16 15:49
 */
@Getter
public enum ResultCodeEnum {
    SUCCESS(0, "成功"),
    FAIL(1, "失败"),
    ;

    private Integer code;

    private String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
