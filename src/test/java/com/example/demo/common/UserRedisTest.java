package com.example.demo.common;


import com.example.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRedisTest {

    @Autowired
    private UserRedis userRedis;
    private Logger logger = LoggerFactory.getLogger(UserRedisTest.class);

    @Test
    public void addTest() {
        User user = new User();
        user.setId(110L);
        user.setName("curry");
        user.setPhone("13366668888");
        user.setEmail("curry@github.com");
        userRedis.add("user", 2L, user);
        logger.info("add user successfully");
    }

    @Test
    public void getTest() {
        String key = "user";
        User user = userRedis.get(key);
        Assert.notNull(user);
        if(user != null) {
            System.out.println(user.getId());
            System.out.println(user.getName());
            System.out.println(user.getPhone());
            System.out.println(user.getEmail());
        }
    }
}
