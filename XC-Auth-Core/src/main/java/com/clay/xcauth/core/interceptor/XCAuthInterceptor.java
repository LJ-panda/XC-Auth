package com.clay.xcauth.core.interceptor;

import com.clay.xcauth.core.factory.TokenFactory;
import com.clay.xcauth.core.model.Token;
import com.clay.xcauth.core.service.CheckService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Calendar;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/1 17:21
 * @Version 1.0
 */
public class XCAuthInterceptor implements HandlerInterceptor {

    public XCAuthInterceptor(){}
    private CheckService checkService;

    private TokenFactory tokenFactory;

    private int refreshGap=20;

    public void setRefreshGap(int refreshGap) {
        this.refreshGap = refreshGap;
    }

    public void setTokenFactory(TokenFactory tokenFactory) {
        this.tokenFactory = tokenFactory;
    }

    public void setCheckService(CheckService checkService) {
        this.checkService = checkService;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        //System.out.println("拦截器处理:"+request.getRequestURI());
        response.setHeader(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS,HttpHeaders.AUTHORIZATION);
        if (request.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.name()))
        {
            response.setStatus(HttpServletResponse.SC_OK);
            response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
            response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET, POST, PUT, DELETE, OPTIONS");
            response.setHeader(HttpHeaders.ACCESS_CONTROL_MAX_AGE, String.valueOf(3600));
            response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "Content-Type, x-requested-with, X-Custom-Header, Authorization");
            return false;
        }

        Method method=((HandlerMethod) handler).getMethod();
        String tokenStr=request.getHeader(HttpHeaders.AUTHORIZATION);
        Token token=tokenFactory.parseToken(tokenStr);
        if (!checkService.checkMethod(method,token))
        {
            throw new Exception("XC-Auth#XCAuthInterceptor：非授权或认证");
        }

        Calendar expire=Calendar.getInstance();
        expire.add(Calendar.MINUTE,refreshGap);
        if (token.getExpire().getTimeInMillis()<=expire.getTimeInMillis())
        {
            token=tokenFactory.refreshToken(token);
            if (token!=null)
            {
                response.setHeader(HttpHeaders.AUTHORIZATION,token.getToken());
            }
        }
        return true;
    }


}
