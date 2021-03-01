package com.clay.xcauth.core.annotation;

import com.clay.xcauth.core.enums.RolePermissionLogic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/2/28 15:14
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface RequirePermissions {
    String[] permissions();

    RolePermissionLogic logic() default RolePermissionLogic.AND;
}
