package com.lb.annotation.author.controller;

import com.lb.annotation.author.annotation.Access;
import com.lb.annotation.author.constant.ResultState;
import com.lb.annotation.author.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author : lb
 * @date : 2020/9/3 18:05
 * @description :
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @PostMapping("/admin")
    @Access(authorities = {"admin"})
    public Map<String, Object> hello(@RequestBody User user){
        return ResultState.SUCCESS.toMap();
    }

}
