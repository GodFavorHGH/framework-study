package com.haugv.controller;

import cn.hutool.core.lang.UUID;
import com.haugv.common.JsonResult;
import com.haugv.constants.dicts.RedisCachePrefix;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
public class StockController {

    @Value("${server.port}")
    private String port;

    @Resource
    RedisTemplate redisTemplate;

    @GetMapping("/stock/deduct")
    public JsonResult deductStock(int commodityId, int count){
//        String lockKey = "lock"+"::"+commodityId;
//        boolean exist = redisTemplate.opsForValue().setIfAbsent(lockKey, count);
        int stock = (int) redisTemplate.opsForHash().get(RedisCachePrefix.COMMODITY_PREFIX+commodityId, "stock");
        if(stock==0){
            return JsonResult.error("current stock is empty");
        }
        if(stock<count){
            return JsonResult.error("current stock is not enough");
        }
        stock-=count;
        redisTemplate.opsForHash().put(RedisCachePrefix.COMMODITY_PREFIX+commodityId, "stock", stock);
        return new JsonResult(200,"success",redisTemplate.opsForHash().get(RedisCachePrefix.COMMODITY_PREFIX+commodityId, "stock"));
    }

    @GetMapping("/stock/set")
    public JsonResult setStock(int commodityId, int stock){
        redisTemplate.opsForValue().set(RedisCachePrefix.COMMODITY_PREFIX+commodityId, stock);
        return new JsonResult(200,"success");
    }

    @GetMapping("/stock/get/{id}/{type}")
    public JsonResult getStock(@PathVariable("id") int commodityId, @PathVariable("type") String key){
        Object stock = redisTemplate.opsForHash().get(RedisCachePrefix.COMMODITY_PREFIX+commodityId, key);
        return new JsonResult(200,"success", stock);
    }

    @GetMapping("/deduct_stock")
    public JsonResult deduct_stock(@RequestParam("id") int id, @RequestParam("count") int count){
        String requestId = UUID.randomUUID().toString();
        String lockkey = "product_"+id;
        String key = RedisCachePrefix.COMMODITY_PREFIX+id;
        boolean exist = redisTemplate.opsForValue().setIfAbsent(lockkey, requestId, 10, TimeUnit.SECONDS);
        if(!exist){
            System.out.println("系统忙，请稍后再试！");
            return JsonResult.error("系统忙，请稍后再试！");
        }
        int stock = (int) redisTemplate.opsForValue().get(key);
        if (stock <= 0) {
            System.out.println("current stock is empty");
            return JsonResult.error("current stock is empty");
        }
        if (stock < count) {
            System.out.println("current stock is not enough");
            return JsonResult.error("current stock is not enough");
        }
        try {
            stock -= 1;
            redisTemplate.opsForValue().set(key, stock);
            System.out.println("from port:" + port + ";" + "剩余库存:" + stock);
        } finally {
            if(requestId.equals(redisTemplate.opsForValue().get(lockkey))){
                redisTemplate.delete(lockkey);
            }
        }
            return new JsonResult(200,"success", null);
    }

    @Resource
    RedissonClient redissonClient;

    @GetMapping("/redisson/deduct_stock")
    public JsonResult redisson_deduct_stock(@RequestParam("id") int id, @RequestParam("count") int count){
        String key = RedisCachePrefix.COMMODITY_PREFIX+id;
        String lockKey = UUID.randomUUID().toString();
        RLock rLock = redissonClient.getLock(lockKey);
        int stock = (int) redisTemplate.opsForValue().get(key);
        if (stock <= 0) {
            System.out.println("current stock is empty");
            return JsonResult.error("current stock is empty");
        }
        if (stock < count) {
            System.out.println("current stock is not enough");
            return JsonResult.error("current stock is not enough");
        }
        try {
            rLock.lock();
            stock -= 1;
            redisTemplate.opsForValue().set(key, stock);
            System.out.println("from port:" + port + ";" + "剩余库存:" + stock);
        } finally {
            rLock.unlock();
        }
        return new JsonResult(200,"success", null);
    }
}
