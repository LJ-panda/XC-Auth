package com.clay.xcauth.imp.likeshiro.service;

import com.clay.xcauth.imp.likeshiro.exception.ParamException;
import com.clay.xcauth.imp.likeshiro.model.UserInfo;

import java.util.Map;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/3 17:28
 * @Version 1.0
 *
 * 密码加密服务
 */
public interface EncryptService {
    /**
     * 获取用户密码的加密值对象
     * @param userInfo userInfo
     * @param salt salt
     * @return newInfo
     * @throws ParamException e
     */
    UserInfo encrypt(UserInfo userInfo,String salt) throws ParamException;

    /**
     * 获取salt
     * 本模块设计的是从用户扩展信息map里自定义键来存储值
     * 然后用户继承{@link AbstractEncryptService}实现getSalt即可获取自己制定的键值
     * @param map extenMap
     * @return str
     */
    String getSalt(Map<String, String>map);
}
