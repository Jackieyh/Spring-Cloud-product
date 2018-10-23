package com.connie.product.exception;

import com.connie.product.enums.ResultEnum;

/**
 * 普通类
 *
 * @Author:Jackie
 * @Date:Created in 2018-10-23 15:46:01
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
