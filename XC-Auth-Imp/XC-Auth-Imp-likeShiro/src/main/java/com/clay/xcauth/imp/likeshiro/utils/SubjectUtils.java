package com.clay.xcauth.imp.likeshiro.utils;

import com.clay.xcauth.core.factory.TokenFactory;
import com.clay.xcauth.core.model.Token;
import com.clay.xcauth.imp.likeshiro.exception.ParamException;
import com.clay.xcauth.imp.likeshiro.exception.SubjectException;
import com.clay.xcauth.imp.likeshiro.model.AuthenticationInfo;
import com.clay.xcauth.imp.likeshiro.model.UserInfo;
import com.clay.xcauth.imp.likeshiro.relam.XCAuthRelam;
import com.clay.xcauth.imp.likeshiro.service.EncryptService;
import com.clay.xcauth.imp.likeshiro.service.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/3 14:06
 * @Version 1.0
 */
public final class SubjectUtils implements SubjectService {

    private SubjectUtils(){}
    private static SubjectUtils instance;
    public static SubjectUtils getInstance()
    {
        if (instance==null)
        {
            synchronized (SubjectUtils.class)
            {
                if (instance==null)
                {
                    instance=new SubjectUtils();
                }
            }
        }
        return instance;
    }
    private Logger log = LoggerFactory.getLogger(SubjectUtils.class);

    private  TokenFactory tokenFactory;

    private  XCAuthRelam relam;

    private  EncryptService encryptService;

    public  void setTokenFactory(TokenFactory tokenFactory) {
        this.tokenFactory = tokenFactory;
    }

    public  void setEncryptService(EncryptService encryptService) {
        this.encryptService = encryptService;
    }

    public  void setRelam(XCAuthRelam relam) {
        this.relam = relam;
    }


    /**
     * 登录
     * @param userInfo
     * @return
     * @throws SubjectException
     * @throws ParamException
     */
    @Override
    public  Token login(UserInfo userInfo) throws SubjectException, ParamException {
        log.debug("login info:{}",userInfo);
        checkSubject(userInfo);
        AuthenticationInfo info=relam.getAuthenticationInfo(userInfo);
        log.debug("认证信息：{}\t\t{}",info,userInfo);
        authenticat(info,
                encryptService.encrypt(userInfo,encryptService.getSalt(info.getExtens())));
        return generateToken(info);
    }

    private  void authenticat(AuthenticationInfo info,UserInfo userInfo) throws SubjectException {
        log.debug("info:{}",info);
        log.debug("userInfo:{}",userInfo);
        if (!(info.getAccount().equals(userInfo.getPrincipal()) && info.getCrypt().equals(userInfo.getPasswd())))
        {
            throw new SubjectException("SubjectUtils#authenticat：account or passwd not match!");
        }
        log.debug("认证通过：{}\n{}",info,userInfo);
    }

    /**
     * 认证成功
     * 生成Token
     * @param info 认证信息
     * @return token
     */
    private  Token generateToken(AuthenticationInfo info)
    {
        log.debug("生成Token：{}",info);
        return tokenFactory.buildToken(info.getAccount(),
                info.getAuthorizationInfo().getPermissions(),
                info.getAuthorizationInfo().getRoles(),info.getExtens());
    }

    /**
     * 检查传入的用户信息对象
     * @param userInfo info
     * @throws SubjectException
     */
    private  void checkSubject(UserInfo userInfo) throws SubjectException {
        if (userInfo==null
        ||userInfo.getPasswd()==null
        ||userInfo.getPasswd().equals("")
        ||userInfo.getPrincipal()==null
        ||userInfo.getPrincipal().equals(""))
        {
            throw new SubjectException("SubjectUtils#checkSubject：userInfo is null or empty");
        }
    }

}
