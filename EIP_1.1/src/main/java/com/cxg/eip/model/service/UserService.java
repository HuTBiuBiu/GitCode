package com.cxg.eip.model.service;


import com.cxg.eip.model.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //查询全部用户信息
    public List<User> getUsers();
    //根据姓名查询用户信息
    public User getByName(String name);
    //添加一个用户
    public boolean addUser(User user);
    //根据用户名和密码查询用户
    public User getUser(String username,String password);
}
