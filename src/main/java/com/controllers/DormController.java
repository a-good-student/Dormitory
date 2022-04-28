package com.controllers;

import com.service.DormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DormController {
    @Autowired
    private DormService dormService;

    //导入学生表数据
    @RequestMapping(value="/dorm_import",method={RequestMethod.POST})
    @ResponseBody
    public List Import(Integer num, String dormId, String dormName, String admin) {
        return dormService.Import(num,dormId,dormName,admin);
    }

    //总记录数
    @RequestMapping(value="/dorm_mount",method={RequestMethod.POST})
    @ResponseBody
    public int page(String dormId, String dormName, String admin) {
        return dormService.Mount(dormId,dormName,admin);
    }

    //总记录数
    @RequestMapping(value="/addDorm",method={RequestMethod.POST})
    @ResponseBody
    public int addDorm(String dormId, String dormName, String bedNum, String bedUse, String admin) {
        return dormService.addDorm(dormId,dormName,bedNum,bedUse,admin);
    }

    //删除
    @RequestMapping(value="/deleteDorm",method={RequestMethod.POST})
    @ResponseBody
    public int deleteDorm(int id) {
        dormService.deleteDorm(id);
        return 1;
    }

    //修改
    @RequestMapping(value="/modDorm",method={RequestMethod.POST})
    @ResponseBody
    public int modDorm(int id, String dormId, String dormName, String bedNum, String bedUse, String admin) {
        return dormService.modClass(id,dormId,dormName,bedNum,bedUse,admin);
    }
}
