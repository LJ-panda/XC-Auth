package com.clay.xcauth.imp.likeshiro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/3 15:54
 * @Version 1.0
 */
public class SimpleAuthorizationInfo implements AuthorizationInfo{
    public SimpleAuthorizationInfo()
    {
        permsssions=new ArrayList<>();
        roles=new ArrayList<>();
    }
    private List<String>permsssions;
    private List<String>roles;

    @Override
    public List<String> getPermissions() {
        return permsssions;
    }

    @Override
    public List<String> getRoles() {
        return roles;
    }

    @Override
    public void setPermisssion(List<String> permisssion) {
        this.permsssions=permisssion;
    }

    @Override
    public void setRoles(List<String> roles) {
        this.roles=roles;
    }
}
