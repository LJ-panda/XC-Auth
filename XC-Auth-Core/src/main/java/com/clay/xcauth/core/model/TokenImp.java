package com.clay.xcauth.core.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/2/28 14:48
 * @Version 1.0
 */
public class TokenImp implements Token {
    private String token;
    private String account;
    private int ttl;
    private Calendar expire;
    private List<String> permissions;
    private List<String> roles;
    private Map<String, String> extenProperts;

    public TokenImp() {
        ttl = TokenConstant.DEFAULT_TTL;
        expire = Calendar.getInstance();
        expire.add(Calendar.MINUTE, ttl);

        permissions = new ArrayList<>();
        roles = new ArrayList<>();
        extenProperts = new ConcurrentHashMap<>();
    }

    @Override
    public Token setToekn(String token) {
        this.token = token;
        return this;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public Token setAccount(String account) {
        this.account = account;
        return this;
    }

    @Override
    public String getAccount() {
        return account;
    }

    @Override
    public Token setTtl(int ttl) {
        this.ttl = ttl;
        return this;
    }

    @Override
    public int getTtl() {
        return ttl;
    }

    @Override
    public Token setExpire(Calendar expire) {
        this.expire = expire;
        return this;
    }

    @Override
    public Calendar getExpire() {
        return expire;
    }

    @Override
    public Token setPermissions(List<String> permissions) {
        this.permissions = permissions;
        return this;
    }

    @Override
    public List<String> getPermission() {
        return permissions;
    }

    @Override
    public Token setRoles(List<String> roles) {
        this.roles = roles;
        return this;
    }

    @Override
    public Token setExten(Map<String, String> exten) {
        this.extenProperts = exten;
        return this;
    }

    @Override
    public Map<String, String> getExten() {
        return extenProperts;
    }

    @Override
    public List<String> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "TokenImp{" +
                "token='" + token + '\'' +
                ", account='" + account + '\'' +
                ", ttl=" + ttl +
                ", expire=" + expire +
                ", permissions=" + permissions +
                ", roles=" + roles +
                ", extenProperts=" + extenProperts +
                '}';
    }
}
