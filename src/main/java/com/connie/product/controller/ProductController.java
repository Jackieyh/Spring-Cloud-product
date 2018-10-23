package com.connie.product.controller;

import com.connie.product.VO.ProductInfoVO;
import com.connie.product.VO.ProductVO;
import com.connie.product.VO.ResultVO;
import com.connie.product.dataobject.ProductCategory;
import com.connie.product.dataobject.ProductInfo;
import com.connie.product.service.CategoryService;
import com.connie.product.service.ProductService;
import com.connie.product.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 普通类
 *
 * @Author:Jackie
 * @Date:Created in 2018-10-22 11:31:04
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 1.查询所有在架的商品
     * 2.获取类目type列表
     * 3.查询类目
     * 4.构造数据
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> list() {
        // 1.查询所有在架的商品
        List<ProductInfo> productList = productService.findUpAll();

        // 2.获取类目type列表
        List<Integer> categoryTypeList = productList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        // 3.查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        // 4.构造数据
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();

            for (ProductInfo productInfo : productList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return ResultVOUtil.success(productVOList);
    }

    @GetMapping("/listForOrder")
    public List<ProductInfo> listForOrder() {
        
    }

}
