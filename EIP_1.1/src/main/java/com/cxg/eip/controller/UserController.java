package com.cxg.eip.controller;

import com.cxg.eip.model.pojo.User;
import com.cxg.eip.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private  UserService userService;
    //个人详情页跳转
    @RequestMapping("/userDetail")
    public String userDetail(){
        return "userDetail";
    }
    //员工管理页跳转
    @RequestMapping("/staff")
    public String staff(Model model){
        List<User> users = userService.getUsers();
        model.addAttribute("users",users);
        return "staff";
    }
}
