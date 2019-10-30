package com.yiki.blog.SecurityLearn;

import io.jsonwebtoken.*;

import java.util.Date;

public class JwtCreateUtil {

    public static void createJwt(){
        JwtBuilder jwtBuilder  = Jwts.builder()
                .setId("001")
                .setSubject("yiki")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"yiki");

        System.out.println(jwtBuilder.compact());
    }
}
