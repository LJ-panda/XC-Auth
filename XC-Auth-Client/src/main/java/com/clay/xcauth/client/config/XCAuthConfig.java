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
@ConfigurationProperties(prefix = "xcauth")
@Configuration
public class XCAuthConfig {
    //privateKey
    private String privateKey;

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    @ConditionalOnMissingBean(TokenFactory.class)
    @Bean
    public TokenFactory tokenFactory()
    {
        System.out.println("私钥："+privateKey);
        JWTUtils.setPrivateKey(privateKey);
        return new TokenFactoryImp();
    }

    @ConditionalOnMissingBean(CheckService.class)
    @Bean
    public CheckService checkService()
    {
        return new CheckServiceImp();
    }

}
