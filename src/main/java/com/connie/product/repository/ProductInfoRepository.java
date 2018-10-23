package com.connie.product.repository;

import com.connie.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 接口类
 *
 * @Author:Jackie
 * @Date:Created in 2018-10-22 11:57:14
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    /**
     * 查询所有在架的商品
     *
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

    List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
