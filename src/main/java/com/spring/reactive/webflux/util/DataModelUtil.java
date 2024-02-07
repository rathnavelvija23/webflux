package com.spring.reactive.webflux.util;

import com.spring.reactive.webflux.entity.Product;
import com.spring.reactive.webflux.model.ProductData;
import org.springframework.beans.BeanUtils;

public class DataModelUtil {

    public static ProductData entitytoDataModel(Product product){
         ProductData productData = new ProductData();
         BeanUtils.copyProperties(product, productData);
         return new ProductData();
    }

    public static ProductData dataModeltoEntity(ProductData productData){
        Product product = new Product();
        BeanUtils.copyProperties(productData, product);
        return new ProductData();
    }
}
