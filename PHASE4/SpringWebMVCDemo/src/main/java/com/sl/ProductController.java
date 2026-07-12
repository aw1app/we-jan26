package com.sl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @GetMapping("/new-product-form")
    public String method1() {
        return "new-product-form"; // go to new-product-form.jsp
    }

    /*FORM PROCESSING APPROACH -1 */
    /*
    @PostMapping("/new-product")
    @ResponseBody
    public String method2(@RequestParam("name") String name, @RequestParam("price") float price){

        return "Successfully added the new product! " + "<br>" + "Name :" + name + "Price :" + price ;
    }
     */

    /*FORM PROCESSING APPROACH -2a */
    /*
    @PostMapping("/new-product")
    @ResponseBody
    public String method2(Product product) {
        return "Successfully added the new product! " +
                "<br>" + "Name :" + product.getName() + "    Price :" + product.getPrice();
    }
     */

    /*FORM PROCESSING APPROACH -2b */
    @PostMapping("/new-product")
    public String method2(Product product, Model model) {
        model.addAttribute("product", product);
        return "new-product-success"; // goes to new-product-success.jsp
    }

    // TASK-1 Add a form feild in new product for specifying in stock (radio button)
}
