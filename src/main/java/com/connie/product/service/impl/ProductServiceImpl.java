package com.connie.product.service.impl;

import com.connie.product.DTO.CartDTO;
import com.connie.product.dataobject.ProductInfo;
import com.connie.product.enums.ProductStatusEnum;
import com.connie.product.enums.ResultEnum;
import com.connie.product.exception.ProductException;
import com.connie.product.repository.ProductInfoRepository;
import com.connie.product.service.ProductService;
import com.google.gson.Gson;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.up.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return repository.findByProductIdIn(productIdList);
    }

    @Override
    public void decreaseStock(List<CartDTO> cartDTOList) {
        List<ProductInfo> list = decreaseStockProcess(cartDTOList);

        // 发送MQ消息
        amqpTemplate.convertAndSend("productInfo", new Gson().toJson(list));
    }

    @Transactional
    public List<ProductInfo> decreaseStockProcess(List<CartDTO> cartDTOList) {
        List<ProductInfo> list = new ArrayList<>();
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
            list.add(productInfo);
        }
        return list;
    }
}
