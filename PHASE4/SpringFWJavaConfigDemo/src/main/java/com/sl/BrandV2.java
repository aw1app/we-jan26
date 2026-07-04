package com.sl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BrandV2 implements IBrand{
    String name = "Phillips";

    public BrandV2(){
    }
    public BrandV2(String name){
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
