package com.example.demo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private JedisPool jedisPool;

    private final static ObjectMapper om = new ObjectMapper();


    public void set(String key, Object value, Integer dbIndex, int expire)  {

        try (Jedis jedis = setDbIndex(dbIndex)) {
            jedis.setex(key, expire, toJson(value));

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    public <T> T get(String key, Class<T> clazz, Integer dbIndex) {

        try (Jedis jedis = setDbIndex(dbIndex)) {
            String value = jedis.get(key);
            return value == null ? null : fromJson(value, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * Object转成JSON数据
     */
    private String toJson(Object object) throws JsonProcessingException {
        if (object instanceof Integer || object instanceof Long || object instanceof Float || object instanceof Double
                || object instanceof Boolean || object instanceof String) {
            return String.valueOf(object);
        }
        return om.writeValueAsString(object);

    }

    /**
     * JSON数据，转成Object
     */
    private <T> T fromJson(String json, Class<T> clazz) throws IOException {
        return om.readValue(json, clazz);

    }

    /**
     * 设置数据库索引
     *
     * @param dbIndex
     */
    private Jedis setDbIndex(Integer dbIndex) {
        if (dbIndex == null || dbIndex > 15 || dbIndex < 0) {
            dbIndex = 0;
        }
        Jedis jedis = jedisPool.getResource();
        String select = jedis.select(dbIndex);
        System.out.println(select);//OK
        return jedis;
    }
}
