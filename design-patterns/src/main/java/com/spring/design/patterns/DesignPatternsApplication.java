package com.spring.design.patterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class DesignPatternsApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(DesignPatternsApplication.class, args);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            System.err.println(beanDefinitionName);
        }

    }

}
