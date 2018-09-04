package com.github.saharag.api.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
//@ImportResource("classpath:applicationContext-hsf-consumer.xml")
public class WebServiceApplication {

    public static void main(String[] args) {
        /*ApplicationContext ctx = */
        SpringApplication.run(WebServiceApplication.class, args);
        // String[] beanNames = ctx.getBeanDefinitionNames();
    }
}
