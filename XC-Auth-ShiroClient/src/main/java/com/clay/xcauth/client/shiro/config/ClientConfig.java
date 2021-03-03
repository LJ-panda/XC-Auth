package com.clay.xcauth.client.shiro.config;

import com.clay.xcauth.core.factory.TokenFactory;
import com.clay.xcauth.core.service.CheckService;
import com.clay.xcauth.imp.core.factory.TokenFactoryImp;
import com.clay.xcauth.imp.core.service.CheckServiceImp;
import com.clay.xcauth.imp.core.utils.JWTUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/3 20:21
 * @Version 1.0
 */
@Import(WebConfig.class)
@Configuration
@ConfigurationProperties(prefix = "xcauth.jwt")
public class ClientConfig {

    private String privateKey;


    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    @Bean
    @ConditionalOnMissingBean(TokenFactory.class)
    public TokenFactory tokenFactory()
    {
        JWTUtils.setPrivateKey(privateKey);
        return new TokenFactoryImp();
    }

    @Bean
    @ConditionalOnMissingBean(CheckService.class)
    public CheckService checkService()
    {
        return new CheckServiceImp();
    }

}
