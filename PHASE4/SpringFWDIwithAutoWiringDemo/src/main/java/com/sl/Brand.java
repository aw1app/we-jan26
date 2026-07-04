package com.sl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Brand implements IBrand{
    String name = "Sony";

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
