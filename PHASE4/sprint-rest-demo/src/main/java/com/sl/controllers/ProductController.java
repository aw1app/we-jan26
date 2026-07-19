package com.sl.controllers;

import com.sl.entities.Product;
import com.sl.repositries.ProductRepositry;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    ProductRepositry productRepositry;

    @GetMapping("/all")
    public List<Product> getProducts() {
        List<Product> products = productRepositry.findAll();

        return products;
    }


    @GetMapping("/details/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        Product prod1 = null;

        Optional<Product> optionalProduct = productRepositry.findById(id);

        if (optionalProduct.isPresent())
            prod1 = optionalProduct.get();

        return prod1;
    }

    // TASK-1: Implement /delete/{id}

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        Optional<Product> optionalProduct = productRepositry.findById(id);
        if (optionalProduct.isPresent()) {
            productRepositry.deleteById(id);
            return "Product found and Deleted";
        }
        return "Product not found.";
    }

    // TASK-2: Implement /add
    @PostMapping("/add")
    @Transactional
    public String addProduct(@RequestBody Product product) {
        Product productAdded = productRepositry.save(product);
        if(productAdded!=null)
        return "Product added succesfully ID=" + productAdded.getId();
        else
            return "Product add failed";
    }

    // Task - 3: /edit/{id}
    @PostMapping("/edit")
    @Transactional
    public String editProduct(@RequestBody Product product) {
        Optional<Product> optionalProduct = productRepositry.findById(product.getId());

        if (optionalProduct.isPresent()) {
            Product prod = optionalProduct.get();
            prod.setName(product.getName());
            prod.setPrice(product.getPrice());
            prod.setDescription(product.getDescription());

            productRepositry.save(prod);
            return "Product updated succesfully for ID=" + prod.getId();
        }
        else
        return "Product update failed";
    }


//    @GetMapping("/{id}")
//    public Product getProduct(@PathVariable("id") int id){
//         Product prod1 = new Product(id, "Dell PC 1 ", 10000.0f, "High end PC");
//
//         return prod1;
//    }


}
