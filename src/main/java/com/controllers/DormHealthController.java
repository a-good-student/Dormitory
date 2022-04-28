package com.controllers;

import com.service.DormHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DormHealthController {
    @Autowired
    private DormHealthService dormHealthService;

    //导入学生表数据
    @RequestMapping(value="/health_import",method={RequestMethod.POST})
    @ResponseBody
    public List Import(Integer num, String dormId, String dormName) {
        return dormHealthService.Import(num,dormId,dormName);
    }

    //总记录数
    @RequestMapping(value="/health_mount",method={RequestMethod.POST})
    @ResponseBody
    public int page(String dormId, String dormName) {
        return dormHealthService.Mount(dormId,dormName);
    }

    //添加
    @RequestMapping(value="/addHealth",method={RequestMethod.POST})
    @ResponseBody
    public int addDormHealth(String dormId, String dormName, String dormHealth, String createTime, String updateTime) {
        return dormHealthService.addDormHealth(dormId,dormName,dormHealth,createTime,updateTime);
    }

    //删除
    @RequestMapping(value="/deleteHealth",method={RequestMethod.POST})
    @ResponseBody
    public int deleteDormHealth(int id) {
        dormHealthService.deleteDormHealth(id);
        return 1;
    }

    //修改
    @RequestMapping(value="/modHealth",method={RequestMethod.POST})
    @ResponseBody
    public int modDormHealth(int id, String dormId, String dormName, String dormHealth, String createTime, String updateTime) {
        return dormHealthService.modDormHealth(id,dormId,dormName,dormHealth,createTime,updateTime);
    }
}
