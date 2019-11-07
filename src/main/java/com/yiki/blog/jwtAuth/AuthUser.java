package com.yiki.blog.jwtAuth;


public class AuthUser {
    private Integer auth_id;
    private String auth_name;
    private String auth_psw;
    private String auth_role;

    public Integer getAuth_id() {
        return auth_id;
    }

    public void setAuth_id(Integer auth_id) {
        this.auth_id = auth_id;
    }

    public String getAuth_name() {
        return auth_name;
    }

    public void setAuth_name(String auth_name) {
        this.auth_name = auth_name;
    }

    public String getAuth_psw() {
        return auth_psw;
    }

    public void setAuth_psw(String auth_psw) {
        this.auth_psw = auth_psw;
    }

    public String getAuth_role() {
        return auth_role;
    }

    public void setAuth_role(String auth_role) {
        this.auth_role = auth_role;
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "auth_id=" + auth_id +
                ", auth_name='" + auth_name + '\'' +
                ", auth_psw='" + auth_psw + '\'' +
                ", auth_role='" + auth_role + '\'' +
                '}';
    }
}
