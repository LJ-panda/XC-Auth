package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2021/3/3 21:07
 * @Version 1.0
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT role FROM t_user_role WHERE userid=#{email}")
    List<String>queryRoles(@Param("email") String email);
    @Select("SELECT per FROM t_user_per WHERE userid=#{email}")
    List<String>queryPermissions(@Param("email") String email);
}
