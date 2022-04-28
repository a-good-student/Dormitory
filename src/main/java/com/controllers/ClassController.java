package com.controllers;

import com.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ClassController {
    @Autowired
    private ClassService classService;

    //导入学生表数据
    @RequestMapping(value="/cla_import",method={RequestMethod.POST})
    @ResponseBody
    public List Import(int num, String classId, String className, String teacher) {
        return classService.Import(num,classId,className,teacher);
    }

    //总记录数
    @RequestMapping(value="/cla_mount",method={RequestMethod.POST})
    @ResponseBody
    public int page(String classId,String className,String teacher) {
        return classService.Mount(classId,className,teacher);
    }

    //总记录数
    @RequestMapping(value="/addClass",method={RequestMethod.POST})
    @ResponseBody
    public int addClass(String classId, String className, String teacher) {
        return classService.addClass(classId,className,teacher);
    }

    //删除
    @RequestMapping(value="/deleteClass",method={RequestMethod.POST})
    @ResponseBody
    public int deleteClass(int id) {
        classService.deleteClass(id);
        return 1;
    }

    //修改
    @RequestMapping(value="/modClass",method={RequestMethod.POST})
    @ResponseBody
    public int modClass(int id, String classId, String className, String teacher) {
        return classService.modClass(id,classId,className,teacher);
    }
}
