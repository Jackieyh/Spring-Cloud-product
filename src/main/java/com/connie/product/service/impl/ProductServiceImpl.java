package com.connie.product.service.impl;

import com.connie.product.DTO.CartDTO;
import com.connie.product.dataobject.ProductInfo;
import com.connie.product.enums.ProductStatusEnum;
import com.connie.product.enums.ResultEnum;
import com.connie.product.exception.ProductException;
import com.connie.product.repository.ProductCategoryRepository;
import com.connie.product.repository.ProductInfoRepository;
import com.connie.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return repository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = repository.findById(cartDTO.getProductId()).get();

            // 判断商品是否存在
            if (productInfo == null) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            // 库存是否足够
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }
}
