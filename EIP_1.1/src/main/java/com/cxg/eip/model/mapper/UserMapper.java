package com.cxg.eip.model.mapper;

import com.cxg.eip.model.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    //查询全部用户信息
    public List<User> getUsers();
    //根据姓名查询用户信息
    public User getByName(@Param("name") String name);
    //添加一个用户
    public boolean addUser(User user);
    //根据用户名和密码查询用户
    public User getUser(@Param("username") String username,@Param("password") String password);
}
