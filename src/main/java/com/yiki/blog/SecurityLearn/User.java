package com.yiki.blog.SecurityLearn;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class User implements UserDetails {

    private Integer userID;
    private String userName;
    private String userRealName;
    private String passWord;
    private Date creatDate;
    private Date lastLoginTime;
    private boolean isAvailable;//是否可用
    private boolean isExpired;//是否过期
    private boolean isLock;//是否锁定
    private boolean identifyIsExpired;//证书是否过期

    private List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();

    public void setAuthorities(List<GrantedAuthority> authorityList) {
        this.authorityList = authorityList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isLock;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return identifyIsExpired;
    }

    @Override
    public boolean isEnabled() {
        return isAvailable;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    public boolean isLock() {
        return isLock;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", userRealName='" + userRealName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", creatDate=" + creatDate +
                ", lastLoginTime=" + lastLoginTime +
                ", isAvailable=" + isAvailable +
                ", isExpired=" + isExpired +
                ", isLock=" + isLock +
                ", identifyIsExpired=" + identifyIsExpired +
                ", authorityList=" + authorityList +
                '}';
    }

    public void setLock(boolean lock) {
        isLock = lock;
    }

    public boolean isIdentifyIsExpired() {
        return identifyIsExpired;
    }

    public void setIdentifyIsExpired(boolean identifyIsExpired) {
        this.identifyIsExpired = identifyIsExpired;
    }
}
