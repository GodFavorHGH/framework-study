package com.haugv.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/stock/deduct")
    public String deductStock(){
        return "deduct success:"+port;
    }

}
