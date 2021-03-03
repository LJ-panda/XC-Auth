package com.clay.xcauth.imp.likeshiro.model;

import java.util.Map;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/3 16:04
 * @Version 1.0
 *
 * 认证信息接口
 */
public interface AuthenticationInfo{
    String getAccount();
    String getCrypt();
    AuthorizationInfo getAuthorizationInfo();
    Map<String, String>getExtens();
}
