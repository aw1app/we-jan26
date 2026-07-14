package com.sl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProjectMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SingletonBean s1 = context.getBean(SingletonBean.class);
        SingletonBean s2 = context.getBean(SingletonBean.class);
        PrototypeBean p1 = context.getBean(PrototypeBean.class);
        PrototypeBean p2 = context.getBean(PrototypeBean.class);
        System.out.println("Singleton same: " + (s1 == s2));
        System.out.println("Prototype same: " + (p1 == p2));
        context.close();
    }
}