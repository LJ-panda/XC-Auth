package com.example.demo.controller;

import com.clay.xcauth.core.annotation.IgnoreAuth;
import com.clay.xcauth.core.annotation.RequirePermissions;
import com.clay.xcauth.core.annotation.RequireRoles;
import com.clay.xcauth.core.enums.RolePermissionLogic;
import com.clay.xcauth.core.model.Token;
import com.clay.xcauth.imp.likeshiro.exception.ParamException;
import com.clay.xcauth.imp.likeshiro.exception.SubjectException;
import com.clay.xcauth.imp.likeshiro.model.SimpleUserInfoImp;
import com.clay.xcauth.imp.likeshiro.model.UserInfo;
import com.clay.xcauth.imp.likeshiro.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/1 21:02
 * @Version 1.0
 */
@Slf4j
@RestController
public class Controller {

    @Autowired
    private SubjectService subjectUtils;

    @GetMapping(value = "/login")
    public String login(String account, String passwd, HttpServletResponse response) throws SubjectException, ParamException {
        UserInfo userInfo=new SimpleUserInfoImp();
        userInfo.setPasswd(passwd);
        userInfo.setPrincipal(account);
        log.info("info:{}",userInfo);
        Token token=subjectUtils.login(userInfo);
        response.addHeader(HttpHeaders.AUTHORIZATION,token.getToken());
        return token.toString();
    }

    @IgnoreAuth
    @RequirePermissions(permissions = {"read","write"},logic = RolePermissionLogic.AND)
    @GetMapping(value = "/other")
    public String other()
    {
        return "other";
    }

    @RequireRoles(roles = {"admin","other"},logic = RolePermissionLogic.OR)
    @GetMapping(value = "/other2")
    public String other2()
    {
        return "other2";
    }

    @GetMapping(value = "/logout")
    public String logout()
    {
        return "out";
    }
}
