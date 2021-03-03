package com.clay.xcauth.imp.likeshiro.model;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/3 16:00
 * @Version 1.0
 *
 * 授权信息
 */
public interface AuthorizationInfo {
    List<String>getPermissions();
    List<String>getRoles();

    void setPermisssion(List<String>permisssion);
    void setRoles(List<String>roles);
}
