package com.clay.xcauth.imp.likeshiro.relam;

import com.clay.xcauth.imp.likeshiro.model.AuthenticationInfo;
import com.clay.xcauth.imp.likeshiro.model.AuthorizationInfo;
import com.clay.xcauth.imp.likeshiro.model.UserInfo;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/3 15:19
 * @Version 1.0
 *
 * 配置用户数据自动获取的relam
 */
@SuppressWarnings("all")
public interface XCAuthRelam {
    /**
     * 获取授权信息
     * @param userInfo info
     * @return
     */
    AuthorizationInfo getAuthorizationInfo(UserInfo userInfo);

    /**
     * 获取认证信息
     * @param userInfo info
     * @return
     */
    AuthenticationInfo getAuthenticationInfo(UserInfo userInfo);
}
