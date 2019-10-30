package com.yiki.blog.SecurityLearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@ResponseBody
@Controller
@RequestMapping("/security")
public class TestController {

    @Autowired
    UserMapper userMapper;


    @GetMapping("/name1")
    public User index1() {

        User user;
        user = userMapper.getUserByUserName("yiki");
        List<Permission> permList = userMapper.getPermissionByUserName("yiki");
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Permission perm : permList) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(perm.getPermTag());
            grantedAuthorities.add(grantedAuthority);
        }
        user.setAuthorities(grantedAuthorities);
        System.out.println(user);
        return user;
    }

    @GetMapping("/name2")
    public List<Permission> name2() {
        return userMapper.getPermissionByUserName("yiki");
    }
}
