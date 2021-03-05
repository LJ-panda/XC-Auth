package com.clay.xcauth.client.config;

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
 * @Date 2021/3/1 16:37
 * @Version 1.0
 */
@Import(WebConfig.class)
@ConfigurationProperties(prefix = "xcauth.jwt")
@Configuration
public class XCAuthConfig {
    private String privateKey;

    private int ttl;

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    @ConditionalOnMissingBean(TokenFactory.class)
    @Bean
    public TokenFactory tokenFactory()
    {
        JWTUtils.setPrivateKey(privateKey);
        TokenFactoryImp tokenFactoryImp=new TokenFactoryImp();
        tokenFactoryImp.setTtl(ttl);
        return tokenFactoryImp;
    }

    @ConditionalOnMissingBean(CheckService.class)
    @Bean
    public CheckService checkService()
    {
        return new CheckServiceImp();
    }

}
