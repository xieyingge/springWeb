package com.example.demo.test;

import com.example.demo.util.RedisUtil;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;


    @org.junit.Test
    public void test() {
        redisUtil.set("oop","pooo",2,10);
    }
}
