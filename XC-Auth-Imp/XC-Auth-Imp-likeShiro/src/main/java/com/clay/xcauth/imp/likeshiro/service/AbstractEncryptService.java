package com.clay.xcauth.imp.likeshiro.service;

import com.clay.xcauth.imp.likeshiro.exception.ParamException;
import com.clay.xcauth.imp.likeshiro.model.UserInfo;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/3 17:47
 * @Version 1.0
 *
 * 需要使用自定义加密服务情况下要实现的抽象类
 */
public abstract class AbstractEncryptService implements EncryptService{
    /**
     * 加密实现
     * @param val pwd
     * @param salt salt
     * @return saltPwd
     * @throws ParamException pe
     */
    public abstract String encrypt(String val,String salt) throws ParamException;

    /**
     * 接口调用
     * @param userInfo info
     * @param salt salt
     * @return info
     * @throws ParamException pe
     */
    @Override
    public final UserInfo encrypt(UserInfo userInfo, String salt) throws ParamException {
        userInfo.setPasswd(encrypt(userInfo.getPasswd(), salt));
        return userInfo;
    }
}
