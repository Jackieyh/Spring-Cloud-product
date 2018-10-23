package com.connie.product.VO;

import lombok.Data;

/**
 * 最外层对象
 *
 * @Author:Jackie
 * @Date:Created in 2018-10-22 14:53:47
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
    private String message;

    /**
     * 具体内容
     */
    private T data;
}
