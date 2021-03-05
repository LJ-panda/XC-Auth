package com.clay.xcauth.core.service;

import com.clay.xcauth.core.model.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/2/28 16:28
 * @Version 1.0
 */
public abstract class AbstractCheckService implements CheckService {

    private Logger log=LoggerFactory.getLogger(AbstractCheckService.class);
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
        log.debug("Token:{}",token);
        return checkPermissions(method, token) && checkRoles(method, token);
    }

    /**
     * 检查用户的角色
     * @param method method
     * @param token token
     * @return boolean
     */
    public abstract boolean checkRoles(Method method, Token token);

    /**
     * 检查用户权限
     * @param method method
     * @param token token
     * @return boolean
     */
    public abstract boolean checkPermissions(Method method, Token token);

    /**
     * 检查是否被注解忽略
     * @param method method
     * @return boolean
     */
    public abstract boolean checkIgnore(Method method);
}
