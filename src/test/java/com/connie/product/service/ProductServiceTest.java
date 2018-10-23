package com.connie.product.service;

import com.connie.product.DTO.CartDTO;
import com.connie.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertNotNull(list);
    }

    @Test
    public void findList() {
        List<ProductInfo> list = productService.findList(Arrays.asList("22f16fcaac86416b8029b4b114677399", "b2d28e2e7737491abecaff584f9fecd9"));
        Assert.assertNotNull(list);
    }

    @Test
    public void decreaseStock() {
        CartDTO cartDTO = new CartDTO("2a1e3b35bff74b4fad7a3c4882564ce5", 10);
        CartDTO cartDTO2 = new CartDTO("uyutyuyt", 100);

        productService.decreaseStock(Arrays.asList(cartDTO, cartDTO2));
    }
}