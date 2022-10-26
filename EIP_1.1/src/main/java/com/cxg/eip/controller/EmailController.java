package com.cxg.eip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmailController {
    @RequestMapping("/email")
    public String email(){
        return "email";
    }
}
