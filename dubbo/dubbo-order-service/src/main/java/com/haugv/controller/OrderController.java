package com.haugv.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.haugv.service.account.AccountService;
import com.haugv.service.order.OrderService;
import com.haugv.service.stock.StockService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    OrderService orderService;

    @GetMapping("/order/create")
    public String createOrder(int userId){
        orderService.createOrder(userId);
        return userId+"create order:success";
    };

}
