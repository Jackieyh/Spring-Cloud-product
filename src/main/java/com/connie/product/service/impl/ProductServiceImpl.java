package com.connie.product.service.impl;

import com.connie.product.dataobject.ProductInfo;
import com.connie.product.enums.ProductStatusEnum;
import com.connie.product.repository.ProductCategoryRepository;
import com.connie.product.repository.ProductInfoRepository;
import com.connie.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 普通类
 *
 * @Author:Jackie
 * @Date:Created in 2018-10-22 14:25:09
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository repository;

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.up.getCode());
    }
}
