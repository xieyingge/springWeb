package com.example.demo.service.impl;

import com.example.demo.dao.SysUserDao;
import com.example.demo.entity.SysUser;
import com.example.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public int updateUser() {
        return sysUserDao.updateUser();
    }

    @Override
    public int insert(SysUser vo) {
        sysUserDao.insert(vo);
        return 1;
    }

    @Override
    public List<SysUser> selectList() {
        return sysUserDao.selectList();
    }
}
