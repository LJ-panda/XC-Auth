package com.clay.xcauth.core.model;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/2/28 14:24
 * @Version 1.0
 */

public interface Token {
    Token setToekn(String token);

    String getToken();

    Token setAccount(String account);

    String getAccount();

    Token setTtl(int ttl);

    int getTtl();

    Token setExpire(Calendar expire);

    Calendar getExpire();

    Token setPermissions(List<String> permissions);

    List<String> getPermission();

    Token setRoles(List<String> roles);

    List<String> getRoles();

    Token setExten(Map<String, String> exten);

    Map<String, String> getExten();
}
