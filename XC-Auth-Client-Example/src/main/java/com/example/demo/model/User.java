package com.example.demo.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/3 21:03
 * @Version 1.0
 */
@Data
@TableName(value = "t_user")
public class User {
    private String username;
    private String passwd;
}
