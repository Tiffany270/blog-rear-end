package com.yiki.blog.SecurityLearn;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {

    public User getUserByUserName(String name);

    //查询用户拥有的权限
    public List<Permission> getPermissionByUserName(String name);

    public  void InsertUser(User user);
}
