package com.haugv.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.haugv.service.account.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public int deductAccountBalance(int userId) {
        System.out.println(userId);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userId;
    }
}
