package com.sl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("officeAddr")
public class OfficeAddress implements IAddress{

    @Override
    public String getAddress() {
        return "OFFICE ADDR";
    }
}
