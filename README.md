## XC-Auth：基于JWT的认证工具，可类似于 Shiro。
### QuickStart
1. 在 Maven 引入以下依赖

    ```XML
    <dependency>
        <groupId>com.clay.xcauth</groupId>
        <artifactId>XC-Auth-Client</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
    ```
 2. 在配置文件 application.yaml 中配置属性
     ```YAML
        xcauth:
          interceptor:
            ## 不拦截的路径，以英文分号隔开（可选）
            excludePath: /login/**;/logout/**;/error;
            ## 要拦截的路径（可选）
            includePath: /**
            ## JWT的token过期前的刷新时间
            refreshGap: 30
          jwt:
            ## JWT的秘钥（必须）
            privateKey: a1346792580
            ## JWT的token基础存活时间（必须）
            ttl: 30
     ```
 3. 如果想开启类似于 Shiro 的玩法，则还需要进行以下操作；如果仅仅是想使用提供的 TokenFactory 用于生成Token则不需要如此。
    >- 实现接口并注入spring上下文：com.clay.xcauth.imp.likeshiro.relam.XCAuthRelam，配置用户的认证数据和授权数据获取方式
    >- 配置Bean：com.clay.xcauth.imp.likeshiro.service.EncryptService
    >- 配置Bean：com.clay.xcauth.imp.likeshiro.service.SubjectService
    >- 如下：                                  
     ```Java
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
    
     ```                                                               


### 项目说明
>- 结构
>>- XC-Auth-Core：核心
>>- XC-Auth-Imp
>>>- XC-Auth-Imp-Core：基本封装和功能实现
>>>- XC-Auth-Imp-LikeShiro：封装类似于Shiro的操作
>>- XC-Auth-Client：进行starter定义，实现自动配置和spring接入。
