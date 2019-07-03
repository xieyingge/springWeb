package com.example.demo.service;

import com.example.demo.entity.SysUser;

import java.util.List;

public interface SysUserService {

    List<SysUser> selectList();

    int updateUser();

    /**
     *  插入
     * @param vo 实体
     * @return 插入数
     */
    int insert(SysUser vo);

}
