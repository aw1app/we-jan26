package com.sl.controllers;

import com.sl.entities.Product;
import com.sl.repositries.ProductRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepositry productRepositry;

    @GetMapping("/all")
    public List<Product> getProducts(){
        List<Product> products = productRepositry.findAll();

        return  products;
    }

//    @GetMapping("/{id}")
//    public Product getProduct(@PathVariable("id") int id){
//         Product prod1 = new Product(id, "Dell PC 1 ", 10000.0f, "High end PC");
//
//         return prod1;
//    }



}
