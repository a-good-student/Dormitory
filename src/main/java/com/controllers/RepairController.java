package com.controllers;

import com.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RepairController {
    @Autowired
    private RepairService repairService;

    //导入学生表数据
    @RequestMapping(value="/repair_import",method={RequestMethod.POST})
    @ResponseBody
    public List Import(Integer num, String dormId, String dormName) {
        return repairService.Import(num,dormId,dormName);
    }

    //总记录数
    @RequestMapping(value="/repair_mount",method={RequestMethod.POST})
    @ResponseBody
    public int page(String dormId, String dormName) {
        return repairService.Mount(dormId,dormName);
    }

    //添加
    @RequestMapping(value="/addRepair",method={RequestMethod.POST})
    @ResponseBody
    public int addRepair(String dormId, String dormName, String repairMan, String repairName, String repairTime, String updateTime) {
        return repairService.addRepair(dormId,dormName,repairMan,repairName,repairTime,updateTime);
    }

    //删除
    @RequestMapping(value="/deleteRepair",method={RequestMethod.POST})
    @ResponseBody
    public int deleteRepair(int id) {
        repairService.deleteRepair(id);
        return 1;
    }

    //修改
    @RequestMapping(value="/modRepair",method={RequestMethod.POST})
    @ResponseBody
    public int modRepair(int id, String dormId, String dormName, String repairMan, String repairName, String repairTime, String updateTime) {
        return repairService.modRepair(id,dormId,dormName,repairMan,repairName,repairTime,updateTime);
    }
}
