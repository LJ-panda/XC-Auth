package com.clay.xcauth.imp.core.utils;

import com.clay.xcauth.core.model.Token;
import com.clay.xcauth.core.model.TokenConstant;
import com.clay.xcauth.core.model.TokenImp;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/1 13:42
 * @Version 1.0
 */
public class JWTUtils {
    private static Logger log = LoggerFactory.getLogger(JWTUtils.class);

    private static String privateKey;

    public static void setPrivateKey(String privateKey) {
        JWTUtils.privateKey = privateKey;
    }

    public static String getPrivateKey() {
        return privateKey;
    }

    private JWTUtils() {
    }

    public static Token build(String account) {
        return build(account, TokenConstant.DEFAULT_TTL);
    }

    public static Token build(String account, int ttl) {
        return build(account, ttl, Calendar.getInstance());
    }

    public static Token build(String account, int ttl, Calendar expire) {
        return build(account, ttl, expire, null, null, null);
    }

    public static Token build(String account, List<String> permission, List<String> roles, Map<String, String> exten) {
        return build(account, TokenConstant.DEFAULT_TTL, Calendar.getInstance(), permission, roles, exten);
    }

    public static Token build(String account, int ttl, List<String> permission, List<String> roles, Map<String, String> exten) {
        return build(account, TokenConstant.DEFAULT_TTL, Calendar.getInstance(), permission, roles, exten);
    }

    public static Token build(String account, int ttl, Calendar expire, List<String> permission, List<String> roles, Map<String, String> exten) {
        expire.add(Calendar.MINUTE, ttl);
        if (Objects.isNull(account) || ttl <= 0 ||
                expire.getTimeInMillis() <= System.currentTimeMillis()) {
            log.error("XC-Auth#JWTUtils：参数异常");
            return null;
        }
        System.out.println("XC-Auth#JWTUtils:私钥"+privateKey);
        Token token = new TokenImp();
        token.setAccount(account)
                .setPermissions(permission)
                .setRoles(roles)
                .setExpire(expire)
                .setTtl(ttl)
                .setExten(exten);
        String tokenStr = Jwts.builder()
                .setSubject(account)
                .setHeaderParam("typ", "JWT")
                .setExpiration(token.getExpire().getTime())
                .claim(TokenConstant.TOKEN, token)
                .setIssuer(TokenConstant.TOKEN_ISSUER)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, privateKey.getBytes())
                .compact();
        token.setToekn(tokenStr);
        return token;
    }


    public static Token parse(String tokenStr) {
        Claims claims = Jwts.parser().setSigningKey(privateKey.getBytes())
                .parseClaimsJws(tokenStr).getBody();
        return JSONUtils.getInstance().convertValue(claims.get(TokenConstant.TOKEN), TokenImp.class);
    }

}
