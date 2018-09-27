package com.example.redis;

import com.example.Example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Example.class)
public class Test2 {

    private static final Logger logger = LoggerFactory.getLogger(Test2.class);

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void test2() {
        redisTemplate.opsForValue().set("springBoot", "SpringDateRedis");
        logger.info("Redis 数据库中获取到的值是：{}", redisTemplate.opsForValue().get("springBoot"));
    }

}
