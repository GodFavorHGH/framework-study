package com.haugv.mapper;

import com.haugv.bean.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
public interface CommodityMapper {

    int createCommodity(Commodity commodity);

    Commodity getCommodity(@Param("id") int commodityId);

    List<Map> listByCondition(@Param("type") String type, @Param("brand") String brand, @Param("model") String model, @Param("minAmount") BigDecimal minAmount, @Param("maxAmount") BigDecimal maxAmount);
    List<Map> listByCondition2(Map map);


}
