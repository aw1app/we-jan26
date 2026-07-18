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
    public String home2(){
        return "home2"; // home2.jsp in webapp/WEB-INF/views
    }


}
