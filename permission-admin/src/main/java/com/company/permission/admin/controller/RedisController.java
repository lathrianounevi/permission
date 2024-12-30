package com.company.permission.admin.controller;

import com.company.permission.common.redis.RedisConfig;
import com.company.permission.common.redis.RedisService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author candylove
 * @date 2024/12/30 15:46
 */
@RestController
public class RedisController {

    @Resource
    private RedisService redisService;

    @GetMapping("/get")
    public String getValue(@RequestParam String key) {
        return (String) redisService.get(key);
    }

    @GetMapping("/set")
    public String setValue(@RequestParam String key, @RequestParam String value) {
        redisService.set(key, value);
        return "value:"+value;
    }


}
