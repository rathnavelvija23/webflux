package com.spring.reactive.webflux.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductData {
    private String id;
    private String name;
    private int qty;
    private double price;
}
