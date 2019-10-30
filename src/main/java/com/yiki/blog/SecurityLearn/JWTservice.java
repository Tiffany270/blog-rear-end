package com.yiki.blog.SecurityLearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JWTservice {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserMapper userMapper;


    public void test(User user) {
        String encodePsw = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassWord(encodePsw);
        userMapper.InsertUser(user);

    }

    public User loginEcode(User user) {

        User admin = userMapper.getUserByUserName(user.getUsername());
        if (admin != null && bCryptPasswordEncoder.matches(user.getPassword(), admin.getPassword()))
        {
            return admin;

        }
            return null;
    }
}
