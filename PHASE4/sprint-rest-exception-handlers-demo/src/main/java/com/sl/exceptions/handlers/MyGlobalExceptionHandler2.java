package com.sl.exceptions.handlers;

import com.sl.exceptions.ProductNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyGlobalExceptionHandler2 {

    @ExceptionHandler(Exception.class)
    public String handleProductNotFoundException(Exception ex){
        return "[GLOBAL]: "+ ex.getMessage() + ". Contact Customer Care.";
    }

}
