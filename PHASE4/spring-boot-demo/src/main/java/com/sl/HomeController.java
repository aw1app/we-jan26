package com.sl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/home")
    @ResponseBody
    public String home(){
        return "Welcome Home!";
    }

    @GetMapping("/home2")
    @ResponseBody
    public String home2(){
        return "Welcome Home 2!";
    }


}
