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
    UserInfo encrypt(UserInfo userInfo,String salt) throws ParamException;

    String getSalt(Map<String, String>map);
}
