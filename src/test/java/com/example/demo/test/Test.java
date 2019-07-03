package com.example.demo.test;


import com.example.demo.service.impl.SysUserServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class Test {

//    @Autowired
    private SysUserServiceImpl sysUserService;

//    @org.junit.Test
    public void test(){
        System.out.println(sysUserService.selectList());
    }

}
