package com.sl.controllers;

import com.sl.dao.ProductDAO;
import com.sl.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {
    @Autowired ProductDAO productDAO;

    @GetMapping("/list-products")
    public String listProducts(Model model){
       List<Product> products = productDAO.getAllProducts();
       model.addAttribute("products",products);

       return "products"; // render products.jsp
    }


    @GetMapping("/new-product-form")
    public String method1() {
        return "new-product-form"; // go to new-product-form.jsp
    }

    /*FORM PROCESSING APPROACH -2b */
    @PostMapping("/new-product")
    public String method2(Product product, Model model) {
        model.addAttribute("product", product);
        return "new-product-success"; // goes to new-product-success.jsp
    }

    // TASK-1 Add a form feild in new product for specifying in stock (radio button)
}
