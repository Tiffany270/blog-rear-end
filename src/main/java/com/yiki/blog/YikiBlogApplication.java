package com.yiki.blog;

import com.yiki.blog.SecurityLearn.JwtCreateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class YikiBlogApplication {




    public static void main(String[] args) {
//        SpringApplication.run(YikiBlogApplication.class, args);
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        //加密"0"
//        String encode = bCryptPasswordEncoder.encode("123");
//        System.out.println(encode);



        //jwt 相关

        JwtCreateUtil.createJwt();

    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }



}
