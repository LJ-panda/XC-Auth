package com.clay.xcauth.core.model;

import java.util.concurrent.TimeUnit;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/2/28 14:54
 * @Version 1.0
 * <p>
 * 常量
 */
public final class TokenConstant {
    private TokenConstant() {
    }

    public static final String TOKEN = "token";
    public static final int DEFAULT_TTL = 60;
    public static final String TOKEN_ISSUER = "Wanderer";
    public static final TimeUnit DEFAULT_TTL_UNIT = TimeUnit.MINUTES;
}
