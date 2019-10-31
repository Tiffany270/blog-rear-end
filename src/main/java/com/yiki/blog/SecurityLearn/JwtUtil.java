package com.yiki.blog.SecurityLearn;

import io.jsonwebtoken.*;

import java.util.Date;

public class JwtUtil {

    public static void createJwt(){
        JwtBuilder jwtBuilder  = Jwts.builder()
                .setId("001")
                .setSubject("yiki")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"yiki")
                .claim("myObj","body");//自定义key

        System.out.println("生成："+jwtBuilder.compact());
        parseJwt(jwtBuilder.compact());

    }

    public  static  void parseJwt(String jwt){
       Claims claims = Jwts.parser()
                .setSigningKey("yiki")
                .parseClaimsJws(jwt)
                .getBody();

        System.out.println("解析:"+claims);
    }
}
