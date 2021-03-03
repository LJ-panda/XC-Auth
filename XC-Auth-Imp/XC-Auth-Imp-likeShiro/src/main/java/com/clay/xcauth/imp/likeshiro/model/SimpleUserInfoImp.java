package com.clay.xcauth.imp.likeshiro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/3 14:10
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleUserInfoImp implements UserInfo {
    private String principal;

    private String passwd;

    private List<String>permissions;

    private List<String>roles;

    @Override
    public String getPrincipal() {
        return this.principal;
    }

    @Override
    public String getPasswd() {
        return this.passwd;
    }

    @Override
    public void setPrincipal(String principal) {
        this.principal=principal;
    }

    @Override
    public void setPasswd(String passwd) {
        this.passwd=passwd;
    }

}
