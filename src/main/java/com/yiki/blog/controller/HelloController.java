package com.yiki.blog.controller;

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
    UserYmlMapper userYmlMapper;



    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userYmlMapper.getUserById(id);
    }



}
