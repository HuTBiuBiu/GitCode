package com.cxg.eip.model.service.impl;

import com.cxg.eip.model.mapper.UserMapper;
import com.cxg.eip.model.pojo.User;
import com.cxg.eip.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        List<User> users = userMapper.getUsers();
        return users;
    }

    @Override
    public User getByName(String name) {
        User user = userMapper.getByName(name);
        return user;
    }

    @Override
    public boolean addUser(User user) {
        boolean b = userMapper.addUser(user);
        return b;
    }

    @Override
    public User getUser(String username, String password) {
        User user = userMapper.getUser(username , password);
        return user;
    }
}
