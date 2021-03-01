package java.com.clay.xcauth.client.config;

import com.clay.xcauth.core.factory.TokenFactory;
import com.clay.xcauth.core.interceptor.XCAuthInterceptor;
import com.clay.xcauth.core.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/1 17:55
 * @Version 1.0
 *
 * 拦截器配置
 * 路径配置
 */
@ConfigurationProperties(prefix = "xcauth.interceptor")
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private String includePath="*;";
    private String excludePath;

    private int refreshGap;

    @SuppressWarnings("all")
    @Autowired
    private TokenFactory tokenFactory;

    @SuppressWarnings("all")
    @Autowired
    private CheckService checkService;

    public void setRefreshGap(int refreshGap) {
        this.refreshGap = refreshGap;
    }

    public void setExcludePath(String excludePath) {
        this.excludePath = excludePath;
    }

    public void setIncludePath(String includePath) {
        this.includePath = includePath;
    }




    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String>include = new ArrayList<>();
        List<String>exclude=new ArrayList<>();
        if (includePath!=null && !includePath.equals(""))
        {
            String[]arr=includePath.split(";");
            for (String item:arr)
            {
                if (item!=null && !item.equals(""))
                {
                    include.add(item);
                }
            }
        }
        if (excludePath!=null && !excludePath.equals(""))
        {
            String []arr=excludePath.split(";");
            for (String item:arr)
            {
                if (item!=null && !item.equals(""))
                {
                    exclude.add(item);
                }
            }
        }
        XCAuthInterceptor interceptor=new XCAuthInterceptor();
        interceptor.setRefreshGap(refreshGap);
        interceptor.setCheckService(checkService);
        interceptor.setTokenFactory(tokenFactory);

        registry.addInterceptor(interceptor)
                .excludePathPatterns(exclude)
                .addPathPatterns(include);
    }

    public void setTokenFactory(TokenFactory tokenFactory) {
        this.tokenFactory = tokenFactory;
    }

    public void setCheckService(CheckService checkService) {
        this.checkService = checkService;
    }
}
