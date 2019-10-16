package com.yiki.blog.Service;

import com.yiki.blog.bean.User;
import com.yiki.blog.mapper.UserYmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserYmlMapper usermapper;

    public User getUserbyId(Integer uid) {
        return usermapper.getUserById(uid);
    }
}
