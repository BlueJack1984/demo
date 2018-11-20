package com.example.demo.common;


import com.example.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRedisTest {

    @Autowired
    private UserRedis userRedis;

    @Test
    public void addTest() {
        User user = new User();
        user.
    }
}
