package com.clay.xcauth.imp.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/1 15:34
 * @Version 1.0
 */
public class JSONUtils {
    private JSONUtils() {
    }

    private static ObjectMapper mapper;

    public static ObjectMapper getInstance() {
        if (mapper == null) {
            synchronized (JSONUtils.class) {
                if (mapper == null) {
                    mapper = new ObjectMapper();
                }
            }
        }
        return mapper;
    }
}
