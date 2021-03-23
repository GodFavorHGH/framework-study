package com.haugv.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.haugv.service.account.AccountService;
import com.haugv.service.order.OrderService;
import com.haugv.service.stock.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Component
@com.alibaba.dubbo.config.annotation.Service(stub = "true")//暴露dubbo接口
public class OrderServiceImpl implements OrderService {

    @Reference//(check = false)//dubbo调用其他应用暴露的接口
    StockService stockService;

    @Reference//(retries = 3)超时重试次数，不包含第一次调用//(check = false)
    AccountService accountService;

    @Override
    public int createOrder(int userId) {
        System.out.println(1);
        stockService.deductStock(userId);
        System.out.println(2);
        accountService.deductAccountBalance(userId);
        System.out.println(3);
        System.out.println(userId);
        return userId;
    }
}
