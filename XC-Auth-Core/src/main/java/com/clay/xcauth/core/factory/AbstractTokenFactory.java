package com.clay.xcauth.core.factory;

import com.clay.xcauth.core.model.Token;
import com.clay.xcauth.core.model.TokenConstant;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/2/28 15:37
 * @Version 1.0
 */
public abstract class AbstractTokenFactory implements TokenFactory {
    @Override
    public Token buildToken(String account) {
        return buildToken(account, TokenConstant.DEFAULT_TTL);
    }

    @Override
    public Token buildToken(String account, int ttl) {
        return buildToken(account, ttl, Calendar.getInstance());
    }

    @Override
    public Token buildToken(String account, int ttl, Calendar expire) {
        return buildToken(account, ttl, expire, null, null, null);
    }

    @Override
    public Token buildToken(String account,
                            List<String> permission,
                            List<String> roles,
                            Map<String, String> exten) {
        return buildToken(account, TokenConstant.DEFAULT_TTL, Calendar.getInstance()
                , permission, roles, exten);
    }

    @Override
    public Token buildToken(String account,
                            int ttl,
                            List<String> permission,
                            List<String> roles,
                            Map<String, String> exten) {
        return buildToken(account, ttl, Calendar.getInstance(), permission, roles, exten);
    }

}
