package com.example.demo.controller;

import com.example.demo.entity.SysUser;
import com.example.demo.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/helloworld")
public class HelloworldController {

    @Autowired
    private SysUserServiceImpl sysUserService;


    //    @ResponseBody
    @RequestMapping("/index")
    public String hello(Model model) {
        try {
            List<SysUser> sysUsers = sysUserService.selectList();
            System.out.println(sysUsers);
            System.out.println("hello world!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "test";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public Object addUser(SysUser user){
        Map m = new HashMap();
        try {
            sysUserService.insert(user);
            System.out.println("hello world!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        m.put("flag", "ok");
        return m;
    }


}
