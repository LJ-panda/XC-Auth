package com.clay.xcauth.imp.likeshiro.utils;

import com.clay.xcauth.imp.likeshiro.exception.ParamException;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/3 17:30
 * @Version 1.0
 */
public final class EncryptUtls {
    public static String md5EncryptToString(String val) throws ParamException {
        if (val==null || val.equals(""))
        {
            throw new ParamException("EncryptUtils#encrypt：encrpt param is null or empty");
        }
        return DigestUtils.md5DigestAsHex(val.getBytes());
    }

    public static void main(String[]args) throws ParamException {
        System.out.println(md5EncryptToString("a1346792580"));
    }


}
