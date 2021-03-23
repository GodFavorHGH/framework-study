package com.haugv.cache;

import com.haugv.constants.dicts.RedisCachePrefix;
import com.haugv.service.CommodityService;
import com.haugv.utils.RedisCacheUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 启动时加载数据库数据到redis缓存
 */
@Component
public class LoadDataToCache implements CommandLineRunner {



    @Resource
    RedisCacheUtil redisCacheUtil;

    @Resource
    CommodityService commodityService;

    @Override
    public void run(String... args) throws Exception {
//        List<Map> commodityList = commodityService.listByCondition(null, null, null, null, null);
//        dealList(commodityList, RedisCachePrefix.COMMODITY_PREFIX);
    }

    /**
     *
     * @param list
     * @param keyPrefix
     */
    private void dealList(List<Map> list, String keyPrefix){
        if (!list.isEmpty()){
            Map item = null;
            for (int i = 0, len = list.size(); i < len; i++) {
                item = list.get(i);
                redisCacheUtil.hsetAll(keyPrefix+item.get("id"), item);
            }
        }
    }

}
