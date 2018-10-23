package com.connie.product.utils;

import com.connie.product.VO.ResultVO;

/**
 * 普通类
 *
 * @Author:Jackie
 * @Date:Created in 2018-10-22 16:09:01
 */
public class ResultVOUtil {
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
