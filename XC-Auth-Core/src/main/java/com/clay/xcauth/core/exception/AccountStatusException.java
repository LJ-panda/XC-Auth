package com.clay.xcauth.core.exception;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/2/28 15:22
 * @Version 1.0
 */
public class AccountStatusException extends XCAuthException {
    public AccountStatusException() {
        super("XC-Auth#AccountStatusException：账户状态异常");
    }
}
