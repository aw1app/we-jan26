package com.sl.controllers;

import com.sl.entities.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public Product getProduct(){
         Product prod1 = new Product(1, "Dell PC 1 ", 10000.0f, "High end PC");

         return prod1;
    }

}
