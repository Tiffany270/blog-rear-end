package com.yiki.blog.SecurityLearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//security提供的自定义类的用户信息巴拉巴拉（可构造）
//UserDetails 接口

@Service
public class YikiUserDetailService implements UserDetailsService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userMapper.getUserByUserName(username);

        List<Permission> permList = userMapper.getPermissionByUserName(username);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Permission perm : permList) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(perm.getPermName());
            grantedAuthorities.add(grantedAuthority);
        }

        user.setAuthorities(grantedAuthorities);
        return user;
    }
}
