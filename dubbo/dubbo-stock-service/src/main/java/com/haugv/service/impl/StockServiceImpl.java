package com.haugv.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.haugv.service.stock.StockService;

@Service
public class StockServiceImpl implements StockService {

    @Override
    public int deductStock(int userId) {
        System.out.println(userId);
        return userId;
    }
}
