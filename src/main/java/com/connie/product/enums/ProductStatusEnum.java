package com.connie.product.enums;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 商品上下架状态
 */
@Getter
public enum ProductStatusEnum {
    up(0, "在架"),
    down(1, "下架"),
    ;

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
