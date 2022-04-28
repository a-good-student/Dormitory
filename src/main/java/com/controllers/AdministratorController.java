package com.controllers;

import com.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;

    //导入学生表数据
    @RequestMapping(value="/adminImport",method={RequestMethod.POST})
    @ResponseBody
    public List Import(Integer num, String adminName, String rank) {
        return administratorService.Import(num,adminName,rank);
    }

    //总记录数
    @RequestMapping(value="/adminMount",method={RequestMethod.POST})
    @ResponseBody
    public int page(String adminName, String rank) {
        return administratorService.Mount(adminName,rank);
    }

    //添加
    @RequestMapping(value="/addAdmin",method={RequestMethod.POST})
    @ResponseBody
    public int addAdmin(String adminName,String name,String adminPhone,String rank,String adminTime) {
        return administratorService.addAdmin(adminName,name,adminPhone,rank,adminTime);
    }

    //删除
    @RequestMapping(value="/deleteAdmin",method={RequestMethod.POST})
    @ResponseBody
    public int deleteAdmin(int id) {
        administratorService.deleteAdmin(id);
        return 1;
    }

    //修改
    @RequestMapping(value="/modAdmin",method={RequestMethod.POST})
    @ResponseBody
    public int modAdmin(int id,String adminName,String name,String adminPhone,String rank,String adminTime) {
        return administratorService.modAdmin(id,adminName,name,adminPhone,rank,adminTime);
    }
}
