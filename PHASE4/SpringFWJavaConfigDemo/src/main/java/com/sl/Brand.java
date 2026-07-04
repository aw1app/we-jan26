package com.sl;

import org.springframework.stereotype.Component;

@Component
public class Brand implements IBrand{
    String name = "Phillips";

    public Brand(){
    }
    public Brand(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void  setName(String name) {
        this.name = name;
    }
}
