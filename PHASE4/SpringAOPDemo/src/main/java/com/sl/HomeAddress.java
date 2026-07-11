package com.sl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("homeAddr")
public class HomeAddress implements IAddress{

    @Override
    public String getAddress() {
        return "HOME ADDR";
    }
}
