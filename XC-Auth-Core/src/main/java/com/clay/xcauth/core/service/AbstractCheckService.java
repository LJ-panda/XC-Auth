package com.clay.xcauth.core.service;

import com.clay.xcauth.core.model.Token;

import java.lang.reflect.Method;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/2/28 16:28
 * @Version 1.0
 */
public abstract class AbstractCheckService implements CheckService {
    /**
     * 基本的检测服务结构
     *
     * @param method 方法
     * @param token  token
     * @return boolean
     */
    @Override
    public boolean checkMethod(Method method, Token token) {
        //注释忽略则直接返回true
        if (checkIgnore(method)) {
            return true;
        }
        return checkPermissions(method, token) && checkRoles(method, token);
    }
}
