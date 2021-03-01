package com.clay.xcauth.imp.factory;

import com.clay.xcauth.core.factory.AbstractTokenFactory;
import com.clay.xcauth.core.model.Token;
import com.clay.xcauth.imp.utils.JWTUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/1 14:55
 * @Version 1.0
 */
public class TokenFactoryImp extends AbstractTokenFactory {
    private static Logger log = LoggerFactory.getLogger(TokenFactoryImp.class);

    @Override
    public Token buildToken(String account, int ttl, Calendar expire, List<String> permission, List<String> roles, Map<String, String> exten) {
        log.debug("TokenFactoryImp#buildToken：{},{},{},{},{},{}", account, ttl, expire, permission, roles, exten);
        return JWTUtils.build(account, ttl, expire, permission, roles, exten);
    }



    @Override
    public Token parseToken(String tokenStr) {
        if (tokenStr == null || tokenStr.equals("")) {
            log.error("TokenFactoryImp#parseToken：tokenStr is null or empty!");
            return null;
        }
        return JWTUtils.parse(tokenStr);
    }

    /**
     * 刷新token
     * 直接将起先解析出来的token对象取出有用的重新默认生成一个即可
     *
     * @param token old
     * @return new
     */
    @Override
    public Token refreshToken(Token token) {
        log.debug("TokenFactoryImp#refreshToken：oldToken is {}", token);
        return buildToken(token.getAccount(), token.getPermission(), token.getRoles(), token.getExten());
    }
}
