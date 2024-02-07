package com.spring.reactive.webflux.service;

import com.spring.reactive.webflux.entity.Product;
import com.spring.reactive.webflux.model.ProductData;
import com.spring.reactive.webflux.repository.ProductRepository;
import com.spring.reactive.webflux.util.DataModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Flux<ProductData> getproducts(){
        return productRepository.findAll().map(DataModelUtil::entitytoDataModel);
    }

    public Mono<ProductData> getProductById(String id){
        return productRepository.findById(id).map(DataModelUtil::entitytoDataModel);
    }

    public Flux<ProductData> getProductsinPriceRange(double min, double max){
        return productRepository.findByPriceBetween(Range.closed(min,max));
    }

//    public Mono<ProductData> saveProduct(Mono<ProductData> productDataMono){
//        return (Mono<ProductData>) productDataMono.map(DataModelUtil::dataModeltoEntity)
//                .flatMap(productRepository::insert)
//                .map((DataModelUtil::entitytoDataModel));


    }

}
