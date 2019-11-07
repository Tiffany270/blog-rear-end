package com.yiki.blog.jwtAuth;

public class JwtResultUtil {


    public static JwtResult success(Object object) {
        JwtResult jwtResult = new JwtResult();
        jwtResult.setCode(0);
        jwtResult.setMsg("成功");
        jwtResult.setData(object);
        return jwtResult;
    }

    public static JwtResult success() {
        return success(null);
    }

    public static  JwtResult error(Integer code,Object object){
        JwtResult jwtResult = new JwtResult();
        jwtResult.setCode(code);
        jwtResult.setMsg("失败");
        jwtResult.setData(object);
        return jwtResult;
    }

}
