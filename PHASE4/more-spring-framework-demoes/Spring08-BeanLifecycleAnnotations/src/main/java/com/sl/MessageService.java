package com.sl;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class MessageService {
    private String message = "Hello Lifecycle";

    public String getMessage() { return message; }

    @PostConstruct
    public void init() {
        System.out.println("[Annotation Lifecycle] MessageService initialized with message: " + message);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("[Annotation Lifecycle] MessageService is about to be destroyed");
    }
}