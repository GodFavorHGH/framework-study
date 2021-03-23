package com.haugv.service.impl;

import com.haugv.bean.Commodity;
import com.haugv.mapper.CommodityMapper;
import com.haugv.service.CommodityService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Resource
    CommodityMapper commodityMapper;

    @Override
    public int createCommodity(Commodity commodity) {
        return commodityMapper.createCommodity(commodity);
    }

    @Override
    public Commodity getCommodity(int commodityId) {
        return commodityMapper.getCommodity(commodityId);
    }

    @Override
    public List<Map> listByCondition(String type, String brand, String model, BigDecimal minAmount, BigDecimal maxAmount) {
        return commodityMapper.listByCondition(type, brand, model, minAmount, maxAmount);
    }

    @Override
    public List<Map> listByCondition2(Map map) {
        return commodityMapper.listByCondition2(map);
    }
}
