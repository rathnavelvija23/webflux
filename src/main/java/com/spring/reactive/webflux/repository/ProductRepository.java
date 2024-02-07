package com.spring.reactive.webflux.repository;

import com.spring.reactive.webflux.entity.Product;
import com.spring.reactive.webflux.model.ProductData;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product,String>{
    Flux<ProductData> findByPriceBetween(Range<Double> priceRange);

    Mono<?> insert(ProductData productData);
}
