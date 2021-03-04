package com.clay.xcauth.imp.likeshiro.service;

import com.clay.xcauth.core.model.Token;
import com.clay.xcauth.imp.likeshiro.exception.ParamException;
import com.clay.xcauth.imp.likeshiro.exception.SubjectException;
import com.clay.xcauth.imp.likeshiro.model.UserInfo;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/4 14:27
 * @Version 1.0
 *
 * 使用登陆接口封装下面的细节
 */
public interface SubjectService  {
    Token login(UserInfo userInfo) throws SubjectException, ParamException;
}
