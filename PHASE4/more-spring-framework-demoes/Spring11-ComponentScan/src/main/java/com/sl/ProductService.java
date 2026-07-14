package com.sl;

import org.springframework.stereotype.Component;

@Component
public class ProductService {
    public String getProduct() {
        return "Spring Component Product";
    }
}