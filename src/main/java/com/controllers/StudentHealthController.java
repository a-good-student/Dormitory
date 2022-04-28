package com.controllers;

import com.service.StudentHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentHealthController {
    @Autowired
    private StudentHealthService studentHealthService;

    //导入学生表数据
    @RequestMapping(value="/studentHealthImport",method={RequestMethod.POST})
    @ResponseBody
    public List Import(Integer num, String sno,String sname, String dormId) {
        return studentHealthService.Import(num,sno,sname,dormId);
    }

    //总记录数
    @RequestMapping(value="/studentHealthMount",method={RequestMethod.POST})
    @ResponseBody
    public int page(String sno,String sname, String dormId) {
        return studentHealthService.Mount(sno, sname, dormId);
    }

    //添加
    @RequestMapping(value="/addStudentHealth",method={RequestMethod.POST})
    @ResponseBody
    public int addStudentHealth(String sno,String sname,String studentHealth,String classId,String dormId, String createTime, String updateTime) {
        return studentHealthService.addStudentHealth(sno,sname,studentHealth,classId,dormId,createTime,updateTime);
    }

    //删除
    @RequestMapping(value="/deleteStudentHealth",method={RequestMethod.POST})
    @ResponseBody
    public int deleteStudentHealth(int id) {
        studentHealthService.deleteStudentHealth(id);
        return 1;
    }

    //修改
    @RequestMapping(value="/modStudentHealth",method={RequestMethod.POST})
    @ResponseBody
    public int modDormHealth(int id, String sno,String sname,String studentHealth,String classId,String dormId, String createTime, String updateTime) {
        return studentHealthService.modStudentHealth(id,sno,sname,studentHealth,classId,dormId,createTime,updateTime);
    }
}
