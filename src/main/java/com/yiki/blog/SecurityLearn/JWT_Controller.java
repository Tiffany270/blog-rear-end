package com.yiki.blog.SecurityLearn;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
@RequestMapping("/jwt")
public class JWT_Controller {

    @Autowired
    private JWTservice jwTservice;

    @GetMapping("/testJwt")
    public void testJwt() {
        User user = new User();
        user.setUserName("test1");
        user.setPassWord("123");

        jwTservice.test(user);

    }
}
