package com.yiki.blog.Service;

import com.yiki.blog.bean.User;
import com.yiki.blog.mapper.UserYmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserYmlMapper usermapper;
    //1.redis注入
    @Autowired
    private RedisTemplate redisTemplate;
    public User getUserbyId(Integer uid) {

        //序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //2.步骤：
        // a.先从缓存中取出当前对象
        ValueOperations ops = redisTemplate.opsForValue();
        User user = (User) ops.get("user_" + uid);
        // a-1.如果缓存中没有,则存到缓存中
        if (user == null) {
            user = usermapper.getUserById(uid);
            ops.set("user_" + uid, user);
        }

        return user;
    }
}
