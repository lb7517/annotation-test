package com.lb.annotation.basic.controller;

import com.lb.annotation.basic.annotation.LoginAnno;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : lb
 * @date : 2020/9/3 9:55
 * @description :
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @GetMapping("/query")
    public String query(String userName){
        return "用户[" + userName + "] 注册成功~!";
    }

    @GetMapping("/login")
    @LoginAnno
    public String login(String userName){
        return "欢迎您: "+ userName;
    }

}
