package com.example.demo.dao;

import com.example.demo.entity.SysUser;

import java.util.List;


public interface SysUserDao {


//    @Select("SELECT * FROM t_sys_user")
    List<SysUser> selectList();

    int updateUser();

    void insert(SysUser vo);
}
