package com.connie.product.repository;

import com.connie.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findByProductStatus() {
        List<ProductInfo> list = repository.findByProductStatus(0);
        Assert.assertNotNull(list);
    }

    @Test
    public void findByProductIdIn() {
        List<ProductInfo> list = repository.findByProductIdIn(Arrays.asList("22f16fcaac86416b8029b4b114677399", "2a1e3b35bff74b4fad7a3c4882564ce5"));
        Assert.assertNotNull(list);
    }
}