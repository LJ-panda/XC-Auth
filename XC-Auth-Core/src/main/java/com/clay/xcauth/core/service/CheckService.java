package com.clay.xcauth.core.service;

import com.clay.xcauth.core.model.Token;

import java.lang.reflect.Method;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/2/28 16:25
 * @Version 1.0
 * <p>
 * 检测服务
 */
public interface CheckService {
    boolean checkMethod(Method method, Token token);

    boolean checkRoles(Method method, Token token);

    boolean checkPermissions(Method method, Token token);

    boolean checkIgnore(Method method);
}
