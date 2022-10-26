package com.cxg.eip.controller;

import com.cxg.eip.model.pojo.User;
import com.cxg.eip.model.service.SuggestionService;
import com.cxg.eip.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegController {
    @Autowired
    private UserService userService;
    @Autowired
    private SuggestionService suggestionService;
    //注册页面跳转
    @RequestMapping(value = "/reg",method = RequestMethod.GET)
    public String regGoReg(){
        return "register";
    }
    //用户注册
    @RequestMapping(value = "/reg",method = RequestMethod.POST)
    public String regUser(String name,String position,String username,String password,String email){
        String privilege = null;
        if ("员工".equals(position))
        {
            privilege="3";
        } else if ("管理员".equals(position)) {
            privilege="1";
        }else {
            privilege="2";
        }
        User user = new User(username,password,name,position,privilege,email);
        userService.addUser(user);
        return "login";
    }





}
