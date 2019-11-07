package com.yiki.blog.jwtAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Service
public class AuthService {

    @Autowired
    private AuthUserMapper authUserMapper;

    @Autowired
    private HttpServletRequest request;


    /*
     * 插入一条用户
     * 返回：用户的id
     * */
    public JwtResult insertAuthUser(AuthUser authUser) {

        try {
            Integer uid = authUserMapper.insertAuthUser(authUser);
            //在mapper中指定了keyProperty会自动绑定
            return JwtResultUtil.success(uid);

        } catch (Exception e) {
            return JwtResultUtil.error(1, e.getMessage());
        }


    }

    /*
     * 验证用户name&psw
     * 返回：user(除密码）+ token
     * */
    public JwtResult authUser(AuthUser authUser) {
        try {
            AuthUser user
                    = authUserMapper.getAuthUserByNameAndPsw(authUser.getAuth_name(), authUser.getAuth_psw());
            if (user != null) {
                String token = JwtTokenUtils.createToken(user.getAuth_name(), user.getAuth_role(), true);
                HashMap<Object, Object> map = new HashMap<Object, Object>();
                map.put("token", token);
                map.put("user", user);
                return JwtResultUtil.success(map);
            } else {
                return JwtResultUtil.error(1, "不存在该用户/不匹配");
            }

        } catch (Exception e) {
            return JwtResultUtil.error(1, e.getMessage());
        }
    }


    public JwtResult test1(Integer id) {
        try {
            String role = (String) request.getAttribute("role");
            System.out.println(">>>>" + role);
            if (role.equals("admin")) {
                AuthUser user = authUserMapper.getAuthUserById(id);
                if (user != null) {
                    return JwtResultUtil.success(user);
                } else {
                    return JwtResultUtil.error(1, "无此用户");
                }
            } else {
                return JwtResultUtil.error(1, "权限不足");

            }

        } catch (Exception e) {
            return JwtResultUtil.error(405, e.getMessage());
        }

    }

    public JwtResult test2(Integer id) {

        try {
            AuthUser user = authUserMapper.getAuthUserById(id);
            if (user != null) {
                return JwtResultUtil.success(user);
            } else {
                return JwtResultUtil.error(1, "token错误");
            }

        } catch (Exception e) {
            return JwtResultUtil.error(405, e.getMessage());
        }

    }
}
