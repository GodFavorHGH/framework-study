package com.haugv.service;

import com.haugv.bean.Commodity;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface CommodityService {

    int createCommodity(Commodity commodity);

    Commodity getCommodity(@Param("id") int commodityId);

    List<Map> listByCondition(String type, String brand, String model, BigDecimal minAmount, BigDecimal maxAmount);

    List<Map> listByCondition2(Map map);
}
