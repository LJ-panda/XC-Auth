package com.clay.xcauth.imp.likeshiro.model;

import lombok.*;

import java.util.Map;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/3 16:04
 * @Version 1.0
 */
public class SimpleAuthenticationInfo implements AuthenticationInfo {

    public SimpleAuthenticationInfo(String account,String crypt,AuthorizationInfo info,Map<String, String>extens)
    {
        this.account=account;
        this.crypt=crypt;
        this.authorizationInfo=info;
        this.extens=extens;
    }
    private String account;

    private String crypt;

    private AuthorizationInfo authorizationInfo;

    private Map<String, String>extens;

    @Override
    public String getAccount() {
        return account;
    }

    @Override
    public String getCrypt() {
        return crypt;
    }

    @Override
    public AuthorizationInfo getAuthorizationInfo() {
        return authorizationInfo;
    }

    @Override
    public Map<String, String> getExtens() {
        return extens;
    }

    @Override
    public String toString() {
        return "SimpleAuthenticationInfo{" +
                "account='" + account + '\'' +
                ", crypt='" + crypt + '\'' +
                ", authorizationInfo=" + authorizationInfo +
                ", extens=" + extens +
                '}';
    }
}
