package com.haugv;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@EnableDubbo//开启基于注解的dubbo
public class DubboAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboAccountApplication.class, args);
    }
}
