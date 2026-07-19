package com.sl.controllers;

import com.sl.entities.Product;
import com.sl.exceptions.ProductNotFoundException;
import com.sl.repositries.ProductRepositry;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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
    public String deleteProduct(@PathVariable("id") int id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepositry.findById(id);
        if (optionalProduct.isPresent()) {
            productRepositry.deleteById(id);
            return "Product found and Deleted";
        } else {
            throw new ProductNotFoundException("Product with id " + id + " does not exist!");
        }
    }

    // TASK-2: Implement /add
    @PostMapping("/add")
    @Transactional
    public String addProduct(@Valid @RequestBody Product product, BindingResult result) {
        // Check if there are validation errors.
        if (result.hasErrors()) {
            StringBuffer errorMessage = new StringBuffer("");
            result.getFieldErrors().forEach(
                    f -> errorMessage.append( "FEILD:" + f.getField() + ": " + f.getRejectedValue() + ". "+ f.getDefaultMessage() ));
            return "Product cannot be added because it has invalid values. " + errorMessage.toString();
        }

        Product productAdded = productRepositry.save(product);
        if (productAdded != null)
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
        } else
            return "Product update failed";
    }


    @ExceptionHandler(ProductNotFoundException.class)
    public String handleProductNotFoundException(Exception ex){
        return "Operation did not complete successfully. Because " + ex.getMessage() + ". Contact Customer Care.";
    }

//    @GetMapping("/{id}")
//    public Product getProduct(@PathVariable("id") int id){
//         Product prod1 = new Product(id, "Dell PC 1 ", 10000.0f, "High end PC");
//
//         return prod1;
//    }


}
