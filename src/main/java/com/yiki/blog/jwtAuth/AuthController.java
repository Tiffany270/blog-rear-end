package com.yiki.blog.jwtAuth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.web.bind.annotation.*;

@ResponseBody
@RestController
@RequestMapping("/jwt")
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping("/register")
    public JwtResult register(@RequestBody AuthUser authUser) {
        return authService.insertAuthUser(authUser);
    }

    @PostMapping("/login")
    public JwtResult login(@RequestBody AuthUser authUser) {
        return authService.authUser(authUser);


    }

    /*用来验证token拦截*/
    @GetMapping("/test1/{id}")
    public JwtResult flter1(@PathVariable("id") Integer id) {
        return authService.test1(id);


    }

    @GetMapping("/test2/{id}")
    public JwtResult flter2(@PathVariable("id") Integer id) {
        return authService.test2(id);
    }


}
