package com.haugv.controller;

import cn.hutool.json.JSONObject;
import com.haugv.common.JsonResult;
import com.haugv.service.CommodityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CommodityController {

    @Resource
    CommodityService commodityService;

    @PostMapping("/commodity/list")
    public JsonResult getCommodityList(@RequestBody JSONObject jsonObject){
        Map map = new HashMap();
        map.put("type", jsonObject.get("type"));
        map.put("brand", jsonObject.get("brand"));
        List list = commodityService.listByCondition2(map);
        return new JsonResult(200,"success",list);
    }
}
