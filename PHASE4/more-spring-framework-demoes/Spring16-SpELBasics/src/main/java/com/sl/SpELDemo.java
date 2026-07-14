package com.sl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpELDemo {
    @Value("#{10 + 20}")
    private int addResult;

    @Value("#{'Hello ' + 'SpEL'}")
    private String concatResult;

    @Value("#{2 * 5}")
    private int multResult;

    public int getAddResult() { return addResult; }
    public String getConcatResult() { return concatResult; }
    public int getMultResult() { return multResult; }
}