package com.haugv;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@EnableDubbo
public class DubboStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboStockApplication.class, args);
    }

}
