package com.yk.vote.service;

import com.yk.vote.po.User;

public interface UserService {

    /**
     * 添加用户
     * @param user
     * @return
     */
    public int saveUser(User user) throws Exception;

    /**
     * 查询用户
     * @param user
     * @return
     */
    public User queryUser(User user) throws Exception;

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User queryUserByUsername(String username) throws Exception;

}
