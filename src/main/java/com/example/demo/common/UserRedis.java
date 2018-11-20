package com.example.demo.common;


import com.example.demo.entity.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class UserRedis {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void add(String key, Long time, User user) {
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(key, gson.toJson(user, User.class), time, TimeUnit.MINUTES);
    }

    public void add(String key, Long time, List<User> userList) {
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(key, gson.toJson(userList), time, TimeUnit.MINUTES);
    }
    public User get(String key) {
        Gson gson = new Gson();
        String ustring = redisTemplate.opsForValue().get(key);
        if(StringUtils.isEmpty(ustring)) {
            return null;
        }
        User user = gson.fromJson(ustring, User.class);
        return user;
    }

    public List<User> getList(String key) {
        Gson gson = new Gson();
        String ustringList = redisTemplate.opsForValue().get(key);
        if(StringUtils.isEmpty(ustringList)) {
            return null;
        }
        List<User> userList = gson.fromJson(ustringList, new TypeToken<List<User>>(){}.getType());
        return userList;
    }
}
