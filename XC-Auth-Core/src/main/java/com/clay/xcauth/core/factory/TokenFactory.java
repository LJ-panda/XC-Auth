package com.clay.xcauth.core.factory;

import com.clay.xcauth.core.model.Token;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/2/28 15:25
 * @Version 1.0
 */
public interface TokenFactory {
    Token buildToken(String account);

    Token buildToken(String account, int ttl);

    Token buildToken(String account, int ttl, Calendar expire);

    Token buildToken(String account,
                     List<String> permission,
                     List<String> roles,
                     Map<String, String> exten);

    Token buildToken(String account,
                     int ttl,
                     List<String> permission,
                     List<String> roles,
                     Map<String, String> exten);

    Token buildToken(String account,
                     int ttl,
                     Calendar expire,
                     List<String> permission,
                     List<String> roles,
                     Map<String, String> exten);

    /**
     * 解析
     *
     * @param tokenStr token
     * @return tokenObj
     */
    Token parseToken(String tokenStr);

    /**
     * 刷新
     *
     * @param token old
     * @return new
     */
    Token refreshToken(Token token);
}
