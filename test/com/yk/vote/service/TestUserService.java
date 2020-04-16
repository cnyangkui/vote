package com.yk.vote.service;

import com.yk.vote.BaseTest;
import com.yk.vote.po.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestUserService extends BaseTest {

    @Autowired
    private UserService userService;


    @Test
    public void findUser() throws Exception {
        User user = new User("admin", "123456");
        User user2 = userService.queryUser(user);
        System.out.println(user2);
    }

    @Test
    public void saveUser() throws Exception {
        User user = new User("aaa", "aaa");
        int res = userService.saveUser(user);
        System.out.println(res);
    }
}
