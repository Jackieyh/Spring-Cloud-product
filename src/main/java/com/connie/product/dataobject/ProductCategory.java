package com.connie.product.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 普通类
 *
 * @Author:Jackie
 * @Date:Created in 2018-10-22 12:05:45
 */
@Table(name = "product_category")
@Data   //lombok注解,省去get/set
@Entity //类与数据库表相对应
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 类目编号
     */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
