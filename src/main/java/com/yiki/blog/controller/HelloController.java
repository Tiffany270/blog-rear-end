package com.yiki.blog.controller;

import com.yiki.blog.Service.UserService;
import com.yiki.blog.bean.User;
import com.yiki.blog.mapper.UserYmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/*
 * 测试用
 * */

@ResponseBody
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }

    @Autowired
    private UserService userService;



    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.getUserbyId(id);
    }



}
