package com.yiki.blog.mapper;

import com.yiki.blog.bean.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserYmlMapper {

    //增删查改

    public User getUserById(Integer uid);

}
