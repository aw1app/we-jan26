package com.sl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpELConditionalDemo {
    @Value("#{10 > 5}")
    private boolean isGreater;

    @Value("#{30 < 20 ? 'Yes' : 'No'}")
    private String ternaryResult;

    @Value("#{null ?: 'Default Name'}")
    private String elvisResult;

    public boolean isGreater() { return isGreater; }
    public String getTernaryResult() { return ternaryResult; }
    public String getElvisResult() { return elvisResult; }
}