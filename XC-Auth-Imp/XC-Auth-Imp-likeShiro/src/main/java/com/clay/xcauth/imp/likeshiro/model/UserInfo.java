package com.clay.xcauth.imp.likeshiro.model;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/3 14:07
 * @Version 1.0
 */
public interface UserInfo {
    String getPrincipal();
    String getPasswd();
    void setPrincipal(String principal);
    void setPasswd(String passwd);
}
