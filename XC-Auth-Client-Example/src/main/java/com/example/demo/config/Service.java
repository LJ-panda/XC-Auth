package com.example.demo.config;

import com.clay.xcauth.imp.likeshiro.exception.ParamException;
import com.clay.xcauth.imp.likeshiro.service.AbstractEncryptService;

import java.util.Map;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/3 20:52
 * @Version 1.0
 */
//@Component
public class Service extends AbstractEncryptService {
    @Override
    public String encrypt(String val, String salt) throws ParamException {
        return null;
    }

    @Override
    public String getSalt(Map<String, String> map) {
        return null;
    }
}
