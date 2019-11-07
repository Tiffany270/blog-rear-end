package com.yiki.blog;

import com.yiki.blog.SecurityLearn.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class YikiBlogApplication {




    public static void main(String[] args) {
        SpringApplication.run(YikiBlogApplication.class, args);
        //jwt 相关
        //JwtUtil.createJwt();

    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }



}
