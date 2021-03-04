package com.example.demo.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.clay.xcauth.imp.likeshiro.model.*;
import com.clay.xcauth.imp.likeshiro.relam.XCAuthRelam;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/3 20:50
 * @Version 1.0
 */
@Slf4j
@Component
public class MyRelam implements XCAuthRelam {
    @Autowired
    private UserMapper userMapper;

    @Override
    public AuthorizationInfo getAuthorizationInfo(UserInfo userInfo) {
        List<String>per=userMapper.queryPermissions(userInfo.getPrincipal());
        List<String>roles=userMapper.queryRoles(userInfo.getPrincipal());
        AuthorizationInfo info=new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setPermisssion(per);
        return info;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(UserInfo userInfo) {
        String account=userInfo.getPrincipal();
        User user=userMapper.selectOne(new QueryWrapper<User>().eq("userName",account));
        log.info("user:{}",user);
        return new SimpleAuthenticationInfo(user.getUsername(),
                user.getPasswd(),getAuthorizationInfo(userInfo),null);
    }
}
