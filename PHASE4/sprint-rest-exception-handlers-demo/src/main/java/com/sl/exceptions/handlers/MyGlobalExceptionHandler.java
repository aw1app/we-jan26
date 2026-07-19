package com.sl.exceptions.handlers;

import com.sl.exceptions.ProductNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyGlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody
    public String handleProductNotFoundException(Exception ex){
        return "[GLOBAL] Operation did not complete successfully. Because " + ex.getMessage() + ". Contact Customer Care.--";
    }

}
