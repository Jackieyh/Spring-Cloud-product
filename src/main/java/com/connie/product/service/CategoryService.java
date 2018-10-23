package com.connie.product.service;

import com.connie.product.dataobject.ProductCategory;

import java.util.List;

/**
 * 接口类
 *
 * @Author:Jackie
 * @Date:Created in 2018-10-22 14:42:46
 */
public interface CategoryService {
    /**
     * 获取类目type列表
     *
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
