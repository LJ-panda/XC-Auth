package com.clay.xcauth.imp.likeshiro.model;

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

    public List<String> getPermsssions() {
        return permsssions;
    }

    public void setPermsssions(List<String> permsssions) {
        this.permsssions = permsssions;
    }

    @Override
    public String toString() {
        return "SimpleAuthorizationInfo{" +
                "permsssions=" + permsssions +
                ", roles=" + roles +
                '}';
    }
}
