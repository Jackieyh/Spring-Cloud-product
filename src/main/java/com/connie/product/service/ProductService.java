package com.connie.product.service;

import com.connie.product.DTO.CartDTO;
import com.connie.product.dataobject.ProductInfo;

import java.util.List;

/**
 * 普通类
 *
 * @Author:Jackie
 * @Date:Created in 2018-10-22 14:22:17
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     *
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     *
     * @param productIdList
     * @return
     */
    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
