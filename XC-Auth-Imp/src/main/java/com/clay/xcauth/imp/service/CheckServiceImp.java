package com.clay.xcauth.imp.service;

import com.clay.xcauth.core.annotation.IgnoreAuth;
import com.clay.xcauth.core.annotation.RequirePermissions;
import com.clay.xcauth.core.annotation.RequireRoles;
import com.clay.xcauth.core.enums.RolePermissionLogic;
import com.clay.xcauth.core.service.AbstractCheckService;
import com.clay.xcauth.core.model.Token;

import java.lang.reflect.Method;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/2/28 17:33
 * @Version 1.0
 * <p>
 * 检测具体实现
 */
public class CheckServiceImp extends AbstractCheckService {
    @Override
    public boolean checkRoles(Method method, Token token) {
        RequireRoles roles = method.getAnnotation(RequireRoles.class);
        if (roles == null) {
            roles = method.getDeclaringClass().getAnnotation(RequireRoles.class);
        }
        if (roles != null) {
            boolean result;
            String[] roleArr = roles.roles();
            RolePermissionLogic logic = roles.logic();
            if (logic == RolePermissionLogic.OR) {
                result = false;
                for (String item : roleArr) {
                    result |= token.getRoles().contains(item);
                }
                return result;
            }
            result = true;
            for (String item : roleArr) {
                result &= token.getRoles().contains(item);
            }
            return result;
        }
        return true;
    }

    @Override
    public boolean checkPermissions(Method method, Token token) {
        RequirePermissions annotation = method.getAnnotation(RequirePermissions.class);
        if (annotation == null) {
            annotation = method.getDeclaringClass().getAnnotation(RequirePermissions.class);
        }
        if (annotation != null) {
            String[] permissions = annotation.permissions();
            RolePermissionLogic logic = annotation.logic();
            boolean result;
            if (logic == RolePermissionLogic.OR) {
                result = false;
                for (String item : permissions) {
                    result |= token.getPermission().contains(item);
                }
                return result;
            }
            result = true;
            for (String item : permissions) {
                result &= token.getPermission().contains(item);
            }
            return result;
        }
        return true;
    }

    /**
     * 判断类或方法是否被忽略
     *
     * @param method m
     * @return boolean
     */
    @Override
    public boolean checkIgnore(Method method) {
        IgnoreAuth ignore = method.getAnnotation(IgnoreAuth.class);
        if (ignore == null) {
            ignore = method.getDeclaringClass().getAnnotation(IgnoreAuth.class);
        }
        return ignore != null;
    }
}
