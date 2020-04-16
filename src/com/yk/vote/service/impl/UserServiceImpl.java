package com.yk.vote.service.impl;

import com.yk.vote.mapper.UserMapper;
import com.yk.vote.po.User;
import com.yk.vote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int saveUser(User user) throws Exception {
        return userMapper.insert(user);
    }

    @Override
    public User queryUser(User user) throws Exception {
        User userInDB = userMapper.selectByPrimaryKey(user.getUserName());
        if(userInDB != null && userInDB.getPassword().equals(user.getPassword())) {
            return userInDB;
        }
        return null;
    }

    @Override
    public User queryUserByUsername(String username) throws Exception {
        return userMapper.selectByPrimaryKey(username);
    }
}
