package com.example.demo.config;

import com.clay.xcauth.core.factory.TokenFactory;
import com.clay.xcauth.imp.likeshiro.relam.XCAuthRelam;
import com.clay.xcauth.imp.likeshiro.service.DefaultEncryptServiceImp;
import com.clay.xcauth.imp.likeshiro.service.EncryptService;
import com.clay.xcauth.imp.likeshiro.service.SubjectService;
import com.clay.xcauth.imp.likeshiro.utils.SubjectUtils;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/3 20:51
 * @Version 1.0
 */
@Setter
@Configuration
public class XCAuthClientConfig {
    @Autowired
    private TokenFactory tokenFactory;

    @Autowired
    private XCAuthRelam relam;

    //@Autowired
    //private EncryptService encryptService;

    @Bean
    public EncryptService encryptService()
    {
        return new DefaultEncryptServiceImp();
    }
    @Bean
    @ConditionalOnMissingBean(SubjectUtils.class)
    public SubjectService subjectUtils()
    {
        SubjectUtils subjectUtils=SubjectUtils.getInstance();
        subjectUtils.setTokenFactory(tokenFactory);
        subjectUtils.setEncryptService(encryptService());
        subjectUtils.setRelam(relam);
        return subjectUtils;
    }
}
