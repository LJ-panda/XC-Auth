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
