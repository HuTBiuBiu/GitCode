package com.cxg.eip.controller;

import com.cxg.eip.model.pojo.Suggestion;
import com.cxg.eip.model.pojo.User;
import com.cxg.eip.model.service.SuggestionService;
import com.cxg.eip.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private SuggestionService suggestionService;
    //get访问主页
    @RequestMapping(value ={"/index"} ,method = RequestMethod.GET)
    public String GetIndex(){
        return "index";
    }
    //get访问登录页
    @RequestMapping(value ={"/login"} ,method = RequestMethod.GET)
    public String GetLogin(){
        return "login";
    }
    //用户登录
    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public String loginUser(HttpSession session, String username, String password){
        User user = userService.getUser(username, password);
        if (user!=null){
            System.out.println(user.getName()+"已登入");
            session.setAttribute("user",user);
            List<Suggestion> suggestions = suggestionService.getSuggestions();
            session.setAttribute("suggestions",suggestions);
            return "redirect:/index";
        }else {
            session.setAttribute("loginmsg","用户名或密码错误!");
            return "login";
        }
    }
    //用户注销(退出)
    @RequestMapping("/exit")
    public String exitUser(HttpSession session){
        session.removeAttribute("user");
        session.invalidate();
        return "index";
    }
}
