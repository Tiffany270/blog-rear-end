package com.yiki.blog.jwtAuth;


/*
 * 拦截器
 * */

import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println(">>>MyInterceptor1>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");

        String header = request.getHeader("Authorization");
        String token = header.substring(7);

        if (header.startsWith("Bearer ")) {
            try {
                Claims claims = JwtTokenUtils.getTokenBody(token);
                String role = (String) claims.get("role");


                if(role!=null&&role.equals("admin")){
                    request.setAttribute("role","admin");
                }
                if(role!=null&&role.equals("test")){
                    request.setAttribute("role","test");
                }

            } catch (Exception e) {
               throw new RuntimeException("token无效");
            }
        }


        return true;// 只有返回true才会继续向下执行，返回false取消当前请求

    }
}
