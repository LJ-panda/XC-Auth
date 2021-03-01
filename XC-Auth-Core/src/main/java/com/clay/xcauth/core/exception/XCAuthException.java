package com.clay.xcauth.core.exception;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/2/28 15:20
 * @Version 1.0
 */
public class XCAuthException extends Exception {
    public XCAuthException() {
        super("XC-Auth#XCAuthException：认证异常");
    }

    public XCAuthException(String msg) {
        super(msg);
    }
}
