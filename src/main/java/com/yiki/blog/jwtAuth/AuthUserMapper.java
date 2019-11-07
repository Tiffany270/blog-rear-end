package com.yiki.blog.jwtAuth;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthUserMapper {

    //增
    public Integer insertAuthUser(AuthUser authUser);

    //删除

    //查
    public AuthUser getAuthUserById(Integer authId);

    public AuthUser getAuthUserByNameAndPsw(String name, String psw);

    //改

}
