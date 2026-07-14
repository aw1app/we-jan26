package com.sl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.sl")
@PropertySource("classpath:application.properties")
public class AppConfig {
}