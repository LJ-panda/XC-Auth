package com.clay.xcauth.imp.likeshiro.service;

import com.clay.xcauth.imp.likeshiro.exception.ParamException;
import com.clay.xcauth.imp.likeshiro.utils.EncryptUtls;

import java.util.Map;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/3 17:54
 * @Version 1.0
 *
 * 默认加密服务
 * 该服务默认从用户扩展数据中获取salt值
 * 如果map为空，则返回空值。
 *
 * 且加密采用工具类{@link EncryptUtls}中的md5实现
 * 本质上，该加密为对密码和salt的拼接取MD5值
 */
public class DefaultEncryptServiceImp extends AbstractEncryptService {
    @Override
    public String getSalt(Map<String, String> map) {
        if (map==null)
        {
            return "";
        }
        return map.get("salt");
    }

    @Override
    public String encrypt(String val, String salt) throws ParamException {
        return EncryptUtls.md5EncryptToString(val+salt);
    }
}
