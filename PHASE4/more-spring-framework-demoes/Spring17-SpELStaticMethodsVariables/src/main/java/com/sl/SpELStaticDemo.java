package com.sl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpELStaticDemo {
    @Value("#{T(java.lang.Math).PI}")
    private double piVal;

    @Value("#{T(java.lang.Math).abs(-42)}")
    private int absVal;

    public double getPiVal() { return piVal; }
    public int getAbsVal() { return absVal; }
}